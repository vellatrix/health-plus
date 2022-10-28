package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.entity.Vendor;

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
  private String zipCode;

}
