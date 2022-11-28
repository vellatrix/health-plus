package org.healthplus.shop.application.dto;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.shop.Address;
import org.healthplus.shop.domain.shop.Business;
import org.healthplus.shop.domain.shop.Shop;
import org.healthplus.shop.domain.shop.VendorId;

@Getter
@Builder
public class ShopRegistrationRequest {

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

  public Shop toShop() {
    return Shop.builder()
            .vendorId(new VendorId(vendorId))
            .minimumPrice(minimumPrice)
            .deliveryFee(deliveryFee)
            .business(Business.builder()
                    .businessName(businessName)
                    .businessNumber(businessNumber)
                    .businessHour(businessHour)
                    .mainType(mainType)
                    .subType(subType)
                    .build())
            .address(new Address(city, street, zipCode))
            .build();
  }
}
