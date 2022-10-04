package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.model.entity.Address;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.enums.IsYn;

import java.time.LocalDateTime;

@Getter
@Builder
public class VendorRegistrationDTO {

  private String id;
  private String password;
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
  private String city;
  private String street;
  private Integer zipCode;

  public Vendor toVendorEntity() {
    return Vendor.builder()
            .id(id)
            .password(password)
            .name(name)
            .bank(bank)
            .accountNumber(accountNumber)
            .email(email)
            .phoneNumber(phoneNumber)
            .timeManagement(new CommonDateTime(LocalDateTime.now()))
            .build();
  }
  
  public Restaurant toRestaurantEntity(Long vendorId) {
    return Restaurant.builder()
            .vendorId(vendorId)
            .businessName(businessName)
            .businessHour(businessHour)
            .businessNumber(businessNumber)
            .mainType(mainType)
            .subType(subType)
            .minimumPrice(minimumPrice)
            .deliveryFee(deliveryFee)
            .address(new Address(city, street, zipCode))
            .build();
  }
}
