package org.healthplus.vendor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.dto.VendorProfileInquiryDTO;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.dto.VendorRegistrationResultDTO;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.entity.OptionGroup;
import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.exception.CustomException;
import org.healthplus.vendor.repository.MenuRepository;
import org.healthplus.vendor.repository.OptionDetailRepository;
import org.healthplus.vendor.repository.OptionGroupRepository;
import org.healthplus.vendor.repository.RestaurantRepository;
import org.healthplus.vendor.repository.VendorRepository;
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
      Long restaurantId = restaurantRepository.findById(vendorId).get().getRestaurantId();
      List<Long> menuIdList = menuRepository.findIdList(restaurantId);
      List<Long> optionGroupIdList = optionGroupRepository.findIdList(menuIdList);
      List<Long> optionDetailIdList = optionDetailRepository.findIdList(optionGroupIdList);

      optionDetailRepository.deleteAllById(optionDetailIdList);
      optionGroupRepository.deleteAllById(optionGroupIdList);
      menuRepository.deleteAllById(menuIdList);
      vendorRepository.deleteById(vendorId);

      return SUCCESS;
    }
    catch (Exception e) {
      throw new CustomException(VENDOR_REMOVAL_FAIL);
    }
  }
}
