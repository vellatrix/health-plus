package org.healthplus.vendor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoListDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.entity.OptionGroup;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.exception.CustomException;
import org.healthplus.vendor.repository.MenuRepository;
import org.healthplus.vendor.repository.OptionDetailRepository;
import org.healthplus.vendor.repository.OptionGroupRepository;
import org.healthplus.vendor.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.healthplus.vendor.enums.Result.SUCCESS;
import static org.healthplus.vendor.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl implements MenuService {

  private final MenuRepository menuRepository;
  private final OptionGroupRepository optionGroupRepository;
  private final OptionDetailRepository optionDetailRepository;

  @Override
  public ProductInfoInquiryDTO getProduct(Long restaurantId, Long productId) {

    ProductInfoInquiryDTO product = menuRepository.findProductInfo(restaurantId, productId);
    List<ProductOptionDetailInfoDTO> optionList = optionDetailRepository.findProductOptionInfo(productId);

    product.addOptionGroup(new ProductOptionGroupInfoDTO(optionList));

    return product;
  }

  @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
  @Override
  public Result updateProduct(Long vendorId, Long productId, ProductInfoListDTO productInfo) {

    long result = menuRepository.modifyProductInfo(vendorId, productId, productInfo);
    if(result == 0) throw new CustomException(MENU_MODIFICATION_FAIL);

    long optionGroupModificationCount = 0;
    long optionDetailModificationCount = 0;
    for(ProductOptionGroupInfoDTO group : productInfo.getOptionGroup()) {
      optionGroupModificationCount += optionGroupRepository.modifyOptionGroupInfo(group);
      optionDetailModificationCount += optionDetailRepository.modifyOptionDetailInfo(group.getOptionDetails());
    }

    if(optionGroupModificationCount != productInfo.getOptionGroup().size()) throw new CustomException(MENU_OPTION_GROUP_UPDATE_FAIL);

    long optionDetailCount = productInfo.getOptionGroup().stream()
            .map(group -> group.getOptionDetails().size())
            .reduce(0, Integer::sum)
            .longValue();

    if(optionDetailModificationCount != optionDetailCount) throw new CustomException(MENU_OPTION_DETAIL_UPDATE_FAIL);

    return SUCCESS;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public List<ProductInfoRegistrationResultDTO> registerProductInfo(Long restaurantId, List<ProductInfoRegistrationDTO> productInfoList) {

    if(restaurantId == null || restaurantId == 0) throw new CustomException(INVALID_RESTAURANT);
    if(productInfoList.size() == 0) throw new CustomException(EMPTY_MENU);

    List<ProductInfoRegistrationResultDTO> dtoList = new ArrayList<>();

    for (ProductInfoRegistrationDTO productInfo : productInfoList) {
      Menu menuEntity = productInfo.toMenuEntity(restaurantId);

      Menu savedMenu = menuRepository.save(menuEntity);

      List<ProductOptionGroupInfoDTO> optionGroupDtoList = new ArrayList<>();

      for(ProductOptionGroupInfoDTO groupInfo : productInfo.getOptionGroup()) {
        OptionGroup savedOptionGroup = optionGroupRepository.save(new OptionGroup(savedMenu.getMenuId(),
                                                                                  groupInfo.getName(),
                                                                                  groupInfo.getBasicChoiceYn(),
                                                                                  groupInfo.getEtcChoiceYn()));

        List<OptionDetail> optionDetails = OptionDetail.addOptionDetails(savedOptionGroup.getOptionGroupId(), groupInfo.getOptionDetails());
        List<OptionDetail> savedOptionDetails = optionDetailRepository.saveAll(optionDetails);
        optionGroupDtoList.add(savedOptionGroup.toOptionGroupDto(OptionDetail.toDTOList(savedOptionDetails)));
      }

      dtoList.add(ProductInfoRegistrationResultDTO.addProduct(savedMenu, optionGroupDtoList));
    }

    return dtoList;
  }

  @Override
  public List<ProductInfoListDTO> getProductList(Long restaurantId) {
    if(restaurantId == null || restaurantId == 0) throw new CustomException(INVALID_VENDOR);

    List<Menu> menuList = menuRepository.findProductListByVendorId(restaurantId);

    List<OptionGroup> groupList = optionGroupRepository.findGroupList(menuList.stream()
            .map(Menu::getMenuId)
            .collect(Collectors.toList()));

    List<OptionDetail> detailList = optionDetailRepository.findDetailList(groupList.stream()
            .map(OptionGroup::getOptionGroupId)
            .collect(Collectors.toList()));

    List<ProductInfoListDTO> menuDtoList = new ArrayList<>(menuList.size());

    for (Menu menu : menuList) {
      List<ProductOptionGroupInfoDTO> optionGroupDtoList = new ArrayList<>();

      for (OptionGroup optionGroup : groupList) {
        List<ProductOptionDetailInfoDTO> optionDetailDtoList = new ArrayList<>();

        for (OptionDetail optionDetail : detailList) {
          if (optionGroup.getOptionGroupId() == optionDetail.getOptionGroupId()) {
            optionDetailDtoList.add(OptionDetail.toDTO(optionDetail));
          }
        }

        if(menu.getMenuId() == optionGroup.getMenuId()) {
          optionGroupDtoList.add(ProductOptionGroupInfoDTO.builder()
                  .optionGroupId(optionGroup.getOptionGroupId())
                  .name(optionGroup.getName())
                  .basicChoiceYn(optionGroup.getBasicChoiceYn())
                  .etcChoiceYn(optionGroup.getEtcChoiceYn())
                  .optionDetails(optionDetailDtoList)
                  .build());
        }
      }

      menuDtoList.add(ProductInfoListDTO.builder()
              .menuId(menu.getMenuId())
              .name(menu.getName())
              .price(menu.getPrice())
              .description(menu.getDescription())
              .useYn(menu.getUseYn())
              .soldYn(menu.getSoldYn())
              .calorie(menu.getCalorie())
              .optionGroup(optionGroupDtoList)
              .build());
    }

    return menuDtoList;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Result removeProductInfo(Long restaurantId, Long productId) {

    List<Long> optionGroupIdList = optionGroupRepository.findIdList(Arrays.asList(productId));
    int executionResult = optionDetailRepository.deleteByOptionGroupIdList(optionGroupIdList);
    optionGroupRepository.deleteByMenuId(productId);
    menuRepository.deleteById(productId);

    if(executionResult == 0) throw new CustomException(MENU_REMOVAL_FAIL);

    return SUCCESS;
  }
}
