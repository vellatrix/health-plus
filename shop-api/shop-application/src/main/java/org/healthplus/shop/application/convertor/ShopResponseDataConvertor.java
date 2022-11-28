package org.healthplus.shop.application.convertor;

import org.healthplus.shop.application.dto.ShopModificationResponse;
import org.healthplus.shop.application.dto.ShopRegistrationResponse;
import org.healthplus.shop.application.dto.ShopRetrievalResponse;
import org.healthplus.shop.domain.shop.Shop;

public class ShopResponseDataConvertor {
  public static ShopRegistrationResponse toShopRegistrationResponse(Shop shop) {
    return ShopRegistrationResponse.builder()
            .vendorId(shop.getVendorId().getVendorId())
            .shopId(shop.getId())
            .minimumPrice(shop.getMinimumPrice())
            .deliveryFee(shop.getDeliveryFee())
            .businessName(shop.getBusiness().getBusinessName())
            .businessNumber(shop.getBusiness().getBusinessNumber())
            .businessHour(shop.getBusiness().getBusinessHour())
            .mainType(shop.getBusiness().getMainType())
            .subType(shop.getBusiness().getSubType())
            .city(shop.getAddress().getCity())
            .street(shop.getAddress().getStreet())
            .zipCode(shop.getAddress().getZipCode())
            .build();
  }

  public static ShopModificationResponse toShopModificationResponse(Shop shop) {
    return ShopModificationResponse.builder()
            .vendorId(shop.getVendorId().getVendorId())
            .shopId(shop.getId())
            .minimumPrice(shop.getMinimumPrice())
            .deliveryFee(shop.getDeliveryFee())
            .businessName(shop.getBusiness().getBusinessName())
            .businessNumber(shop.getBusiness().getBusinessNumber())
            .businessHour(shop.getBusiness().getBusinessHour())
            .mainType(shop.getBusiness().getMainType())
            .subType(shop.getBusiness().getSubType())
            .city(shop.getAddress().getCity())
            .street(shop.getAddress().getStreet())
            .zipCode(shop.getAddress().getZipCode())
            .build();
  }

  public static ShopRetrievalResponse toShopRetrievalResponse(Shop shop) {
    return ShopRetrievalResponse.builder()
            .vendorId(shop.getVendorId().getVendorId())
            .shopId(shop.getId())
            .minimumPrice(shop.getMinimumPrice())
            .deliveryFee(shop.getDeliveryFee())
            .businessName(shop.getBusiness().getBusinessName())
            .businessNumber(shop.getBusiness().getBusinessNumber())
            .businessHour(shop.getBusiness().getBusinessHour())
            .mainType(shop.getBusiness().getMainType())
            .subType(shop.getBusiness().getSubType())
            .city(shop.getAddress().getCity())
            .street(shop.getAddress().getStreet())
            .zipCode(shop.getAddress().getZipCode())
            .build();
  }
}
