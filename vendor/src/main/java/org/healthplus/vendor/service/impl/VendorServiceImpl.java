package org.healthplus.vendor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.entity.*;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.exception.CustomException;
import org.healthplus.vendor.repository.*;
import org.healthplus.vendor.service.VendorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.healthplus.vendor.enums.Result.SUCCESS;
import static org.healthplus.vendor.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorServiceImpl implements VendorService {

  private final VendorRepository vendorRepository;
  private final RestaurantRepository restaurantRepository;
  private final MenuRepository menuRepository;
  private final OptionGroupRepository optionGroupRepository;
  private final OptionDetailRepository optionDetailRepository;

  @Override
  public ProductInfoInquiryDTO getProduct(Long vendorId, Long productId) {

    ProductInfoInquiryDTO product = vendorRepository.findProductInfo(vendorId, productId);
    List<ProductOptionDetailInfoDTO> optionList = vendorRepository.findProductOptionInfo(productId);

    product.addOptionGroup(new ProductOptionGroupInfoDTO(optionList));

    return product;
  }

  @Override
  public RestaurantInfoInquiryDTO getRestaurant(Long vendorId) {
    return vendorRepository.findRestaurantInfo(vendorId);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Result updateProduct(Long vendorId, Long productId, ProductInfoDTO productInfo) {

    long result = menuRepository.modifyProductInfo(vendorId, productId, productInfo);
    if(result == 0) throw new CustomException(MENU_MODIFICATION_FAIL);

    long optionCount = productInfo.getOptionGroup().getOptionDetails().size();
    long successCount = menuRepository.modifyOptionDetailInfo(productInfo.getOptionGroup().getOptionDetails());

    if(successCount != optionCount) throw new CustomException(MENU_OPTION_UPDATE_FAIL);

    return SUCCESS;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public ProductInfoRegistrationResultDTO registerProductInfo(Long restaurantId, ProductInfoRegistrationDTO productInfo) {

    Menu menuEntity = productInfo.toMenuEntity(restaurantId);

    Menu savedMenu = menuRepository.save(menuEntity);

    OptionGroup savedOptionGroup = optionGroupRepository.save(new OptionGroup(savedMenu.getMenuId()));

    List<OptionDetail> optionDetails = OptionDetail.addOptionDetails(savedOptionGroup.getOptionGroupId(), productInfo.getOptionGroup().getOptionDetails());

    List<OptionDetail> savedOptionDetails;
    if(optionDetails.size() != 0) {
      savedOptionDetails = optionDetailRepository.saveAll(optionDetails);
    }
    else {
      savedOptionDetails = Collections.EMPTY_LIST;
      log.info("No Menu Option Detail to register");
    }

    return ProductInfoRegistrationResultDTO.addProduct(savedMenu, savedOptionDetails);
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public VendorRegistrationResultDTO registerVendor(VendorRegistrationDTO vendorInfo) {

    Vendor savedVendor = vendorRepository.save(vendorInfo.toVendorEntity());

    Restaurant savedRestaurant = restaurantRepository.save(vendorInfo.toRestaurantEntity(savedVendor.getVendorId()));

    return VendorRegistrationResultDTO.addVendorAndRestaurant(savedVendor, savedRestaurant);

  }

  @Override
  public VendorProfileInquiryDTO getVendorProfile(Long vendorId) {

    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new CustomException(INVALID_VENDOR));
    Restaurant restaurant = restaurantRepository.findByVendorId(vendorId);

    return VendorProfileInquiryDTO.setProfile(vendor, restaurant);
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  @Override
  public Result removeVendor(Long vendorId) {
    try {
      vendorRepository.deleteById(vendorId);
      Long restaurantId = restaurantRepository.findById(vendorId).get().getRestaurantId();
      List<Long> menuIdList = menuRepository.findIdList(restaurantId);
      menuRepository.deleteAllById(menuIdList);
      List<Long> optionGroupIdList = optionGroupRepository.findIdList(menuIdList);
      optionGroupRepository.deleteAllById(optionGroupIdList);
      List<Long> optionDetailIdList = optionDetailRepository.findIdList(optionGroupIdList);
      optionDetailRepository.deleteAllById(optionDetailIdList);

      return SUCCESS;
    }
    catch (Exception e) {
      throw new CustomException(VENDOR_REMOVAL_FAIL);
    }
  }
}
