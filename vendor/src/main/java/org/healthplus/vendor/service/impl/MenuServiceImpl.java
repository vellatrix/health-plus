package org.healthplus.vendor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
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
  public ProductInfoDTO getProduct(Long restaurantId, Long productId) {

    Menu menu = menuRepository.findById(productId).orElseThrow(() -> new CustomException(INVALID_MENU));
    List<Menu> menuList = Collections.singletonList(menu);
    List<OptionGroup> optionGroupList = optionGroupRepository.findAllByMenuId(productId);
    List<OptionDetail> optionDetailList = optionDetailRepository.findAllByOptionGroupIdIn(optionGroupList.stream()
            .map(optionGroup -> optionGroup.getOptionGroupId())
            .collect(Collectors.toList()));

    List<ProductInfoDTO> productsDto = getProductsDto(menuList, optionGroupList, optionDetailList);

    return productsDto.get(0);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public List<ProductInfoDTO> updateProduct(Long restaurantId, Long productId, ProductInfoDTO productInfo) {
    if(restaurantId == null || restaurantId == 0) throw new CustomException(INVALID_RESTAURANT);

    long result = menuRepository.modifyProductInfo(restaurantId, productId, productInfo);
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

    List<Menu> updatedMenu = Collections.singletonList(menuRepository.findById(productId).get());
    List<OptionGroup> updatedOptionGroupList = optionGroupRepository.findAllByMenuId(updatedMenu.get(0).getMenuId());
    List<Long> optionGroupIdList = updatedOptionGroupList.stream()
            .map(optionGroup -> optionGroup.getOptionGroupId())
            .collect(Collectors.toList());

    List<OptionDetail> updatedOptionDetailList = optionDetailRepository.findAllByOptionGroupIdIn(optionGroupIdList);

    List<ProductInfoDTO> productListDto = getProductsDto(updatedMenu, updatedOptionGroupList, updatedOptionDetailList);

    return productListDto;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public List<ProductInfoRegistrationResultDTO> registerProductInfo(Long restaurantId, List<ProductInfoRegistrationDTO> productInfoList) {

    if(restaurantId == null || restaurantId == 0) throw new CustomException(INVALID_RESTAURANT);
    if(CollectionUtils.isEmpty(productInfoList)) throw new CustomException(EMPTY_MENU);

    List<ProductInfoRegistrationResultDTO> dtoList = new ArrayList<>();

    for (ProductInfoRegistrationDTO productInfo : productInfoList) {
      Menu menu = Menu.builder()
              .restaurantId(restaurantId)
              .categoryId(productInfo.getCategoryId())
              .name(productInfo.getName())
              .price(productInfo.getPrice())
              .calorie(productInfo.getCalorie())
              .description(productInfo.getDescription())
              .menuType(productInfo.getMenuType())
              .build();

      Menu savedMenu = menuRepository.save(menu);

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

      ProductInfoRegistrationResultDTO resultDto = ProductInfoRegistrationResultDTO.builder()
              .menuId(savedMenu.getMenuId())
              .restaurantId(savedMenu.getRestaurantId())
              .categoryId(savedMenu.getCategoryId())
              .type(savedMenu.getMenuType().name())
              .description(savedMenu.getDescription())
              .soldYn(savedMenu.getSoldYn())
              .useYn(savedMenu.getUseYn())
              .createdAt(savedMenu.getCreatedAt())
              .name(savedMenu.getName())
              .price(savedMenu.getPrice())
              .calorie(savedMenu.getCalorie())
              .optionGroups(optionGroupDtoList)
              .build();

      dtoList.add(resultDto);
    }

    return dtoList;
  }

  @Override
  public List<ProductInfoDTO> getProductList(Long restaurantId) {
    if(restaurantId == null || restaurantId == 0) throw new CustomException(INVALID_VENDOR);

    List<Menu> menuList = menuRepository.findAllByRestaurantId(restaurantId);

    List<OptionGroup> groupList = optionGroupRepository.findGroupList(menuList.stream()
            .map(Menu::getMenuId)
            .collect(Collectors.toList()));

    List<OptionDetail> detailList = optionDetailRepository.findDetailList(groupList.stream()
            .map(OptionGroup::getOptionGroupId)
            .collect(Collectors.toList()));

    List<ProductInfoDTO> menuDtoList = getProductsDto(menuList, groupList, detailList);

    return menuDtoList;
  }

  @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
  @Override
  public Result removeProductInfo(Long restaurantId, Long productId) {

    List<Long> optionGroupIdList = optionGroupRepository.findIdList(Arrays.asList(productId));
    int executionResult = optionDetailRepository.deleteByOptionGroupIdList(optionGroupIdList);
    optionGroupRepository.deleteByMenuId(productId);
    menuRepository.deleteById(productId);

    if(executionResult == 0) throw new CustomException(MENU_REMOVAL_FAIL);

    return SUCCESS;
  }

  private List<ProductInfoDTO> getProductsDto(List<Menu> menuList, List<OptionGroup> groupList, List<OptionDetail> detailList) {
    List<ProductInfoDTO> menuDtoList = new ArrayList<>();
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
          optionGroupDtoList.add(OptionGroup.toDTO(optionGroup, optionDetailDtoList));
        }
      }

      menuDtoList.add(Menu.toDTO(menu, optionGroupDtoList));
    }
    return menuDtoList;
  }

  @Override
  public Page<ProductInfoByCategoryDTO> getProductListByCategoryId(Long categoryId, Pageable pageable) {

    Page<ProductInfoByCategoryDTO> menuList = menuRepository.findByCategoryId(categoryId, pageable);

    return menuList;
  }
}
