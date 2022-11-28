package org.healthplus.shop.application.dto;

import lombok.Getter;
import org.healthplus.shop.domain.shop.Shop;

@Getter
public class ShopModificationRequest {

  private String businessHour;
  private Integer deliveryFee;
  private Integer minimumPrice;

  public Shop toShop(Long shopId) {
    return new Shop(shopId, businessHour, deliveryFee, minimumPrice);
  }
}
