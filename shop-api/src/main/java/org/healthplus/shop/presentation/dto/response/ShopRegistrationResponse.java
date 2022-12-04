package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ShopRegistrationResponse {

  private Long shopId;
  private Long vendorId;
  private Integer minimumPrice;
  private Integer deliveryFee;
  private String businessName;
  private String businessNumber;
  private String businessHour;
  private String mainType;
  private String subType;
  private String city;
  private String street;
  private String zipCode;

}
