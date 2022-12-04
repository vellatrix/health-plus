package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;

@Getter
public class ShopRegistrationRequest {

  private Integer categoryId;
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
