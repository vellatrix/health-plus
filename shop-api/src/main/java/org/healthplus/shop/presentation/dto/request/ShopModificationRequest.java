package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;

@Getter
public class ShopModificationRequest {

  private Integer minimumPrice;
  private Integer deliveryFee;
  private String businessHour;

}
