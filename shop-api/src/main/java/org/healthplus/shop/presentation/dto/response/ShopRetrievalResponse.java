package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ShopRetrievalResponse {

  private Long vendorId;
  private Long shopId;
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
  private Integer menuCount;
  private List<MenuRetrievalResponse> menus;
}
