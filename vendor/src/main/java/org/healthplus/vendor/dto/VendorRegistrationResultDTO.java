package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.enums.IsYn;

@Getter
@Builder
public class VendorRegistrationResultDTO {

  private Long menuId;
  private Long restaurantId;
  private String name;
  private String bank;
  private String accountNumber;
  private String email;
  private String phoneNumber;
  private String businessName;
  private String businessHour;
  private String businessNumber;
  private String mainType;
  private String subType;
  private Integer minimumPrice;
  private Integer deliveryFee;
  private IsYn openYn;
  private String city;
  private String street;
  private String zipCode;

  public static VendorRegistrationResultDTO addVendorAndRestaurant(Vendor savedVendor, Restaurant savedRestaurant) {
    return VendorRegistrationResultDTO.builder()
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
  }

}
