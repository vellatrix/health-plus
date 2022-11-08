package org.healthplus.vendor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.VendorProfileInquiryDTO;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.dto.VendorRegistrationResultDTO;
import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.exception.CustomException;
import org.healthplus.vendor.repository.MenuRepository;
import org.healthplus.vendor.repository.OptionDetailRepository;
import org.healthplus.vendor.repository.OptionGroupRepository;
import org.healthplus.vendor.repository.RestaurantRepository;
import org.healthplus.vendor.repository.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.healthplus.vendor.enums.Result.SUCCESS;
import static org.healthplus.vendor.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorService {

  private final VendorRepository vendorRepository;
  private final RestaurantRepository restaurantRepository;
  private final MenuRepository menuRepository;
  private final OptionGroupRepository optionGroupRepository;
  private final OptionDetailRepository optionDetailRepository;


  @Transactional(rollbackFor = Exception.class)
  public VendorRegistrationResultDTO registerVendor(VendorRegistrationDTO vendorDto) {

    Vendor vendor = Vendor.builder()
            .id(vendorDto.getId())
            .password(vendorDto.getPassword())
            .name(vendorDto.getName())
            .bank(vendorDto.getBank())
            .accountNumber(vendorDto.getAccountNumber())
            .email(vendorDto.getEmail())
            .phoneNumber(vendorDto.getPhoneNumber())
            .build();

    Vendor savedVendor = vendorRepository.save(vendor);

    Restaurant restaurant = Restaurant.builder()
            .vendorId(savedVendor.getVendorId())
            .businessName(vendorDto.getBusinessName())
            .businessHour(vendorDto.getBusinessHour())
            .businessNumber(vendorDto.getBusinessNumber())
            .mainType(vendorDto.getMainType())
            .subType(vendorDto.getSubType())
            .minimumPrice(vendorDto.getMinimumPrice())
            .deliveryFee(vendorDto.getDeliveryFee())
            .city(vendorDto.getCity())
            .street(vendorDto.getStreet())
            .zipCode(vendorDto.getZipCode())
            .build();

    Restaurant savedRestaurant = restaurantRepository.save(restaurant);

    VendorRegistrationResultDTO vendorRegistrationResultDTO = VendorRegistrationResultDTO.builder()
            .menuId(savedVendor.getVendorId())
            .name(savedVendor.getName())
            .bank(savedVendor.getBank())
            .accountNumber(savedVendor.getAccountNumber())
            .email(savedVendor.getEmail())
            .phoneNumber(savedVendor.getPhoneNumber())
            .restaurantId(savedRestaurant.getRestaurantId())
            .businessName(savedRestaurant.getBusinessName())
            .businessHour(savedRestaurant.getBusinessHour())
            .businessNumber(savedRestaurant.getBusinessNumber())
            .mainType(savedRestaurant.getMainType())
            .subType(savedRestaurant.getSubType())
            .minimumPrice(savedRestaurant.getMinimumPrice())
            .deliveryFee(savedRestaurant.getDeliveryFee())
            .openYn(savedRestaurant.getOpenYn())
            .city(savedRestaurant.getCity())
            .street(savedRestaurant.getStreet())
            .zipCode(savedRestaurant.getZipCode())
            .build();

    return vendorRegistrationResultDTO;

  }

  public VendorProfileInquiryDTO getVendorProfile(Long vendorId) {

    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(() -> new CustomException(INVALID_VENDOR));
    Restaurant restaurant = restaurantRepository.findByVendorId(vendorId);

    VendorProfileInquiryDTO vendorProfileInquiryDTO = VendorProfileInquiryDTO.builder()
            .menuId(vendor.getVendorId())
            .name(vendor.getName())
            .bank(vendor.getBank())
            .accountNumber(vendor.getAccountNumber())
            .email(vendor.getEmail())
            .phoneNumber(vendor.getPhoneNumber())
            .restaurantId(restaurant.getRestaurantId())
            .businessName(restaurant.getBusinessName())
            .businessHour(restaurant.getBusinessHour())
            .businessNumber(restaurant.getBusinessNumber())
            .mainType(restaurant.getMainType())
            .subType(restaurant.getSubType())
            .minimumPrice(restaurant.getMinimumPrice())
            .deliveryFee(restaurant.getDeliveryFee())
            .openYn(restaurant.getOpenYn())
            .city(restaurant.getCity())
            .street(restaurant.getStreet())
            .zipCode(restaurant.getZipCode())
            .build();

    return vendorProfileInquiryDTO;
  }

  @Transactional(isolation = Isolation.SERIALIZABLE)
  public Result removeVendor(Long vendorId) {
    try {
      Long restaurantId = restaurantRepository.findById(vendorId).orElseThrow(() -> new CustomException(INVALID_RESTAURANT)).getRestaurantId();
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
