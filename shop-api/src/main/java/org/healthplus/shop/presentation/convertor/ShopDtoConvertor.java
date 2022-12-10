package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.entity.Address;
import org.healthplus.shop.domain.entity.Business;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Option;
import org.healthplus.shop.domain.entity.OptionGroup;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.entity.ShopCategory;
import org.healthplus.shop.presentation.dto.request.ShopModificationRequest;
import org.healthplus.shop.presentation.dto.request.ShopRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.MenuRetrievalResponse;
import org.healthplus.shop.presentation.dto.response.OptionGroupRetrievalResponse;
import org.healthplus.shop.presentation.dto.response.OptionRetrievalResponse;
import org.healthplus.shop.presentation.dto.response.ShopModificationResponse;
import org.healthplus.shop.presentation.dto.response.ShopRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.ShopRetrievalResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ShopDtoConvertor {
  public static Shop toRegistrationRequest(Long vendorId, ShopRegistrationRequest dto) {
    return Shop.builder()
            .vendorId(vendorId)
            .category(new ShopCategory(dto.getCategoryId()))
            .minimumPrice(dto.getMinimumPrice())
            .deliveryFee(dto.getDeliveryFee())
            .business(Business.builder()
                    .businessName(dto.getBusinessName())
                    .businessHour(dto.getBusinessHour())
                    .businessNumber(dto.getBusinessNumber())
                    .mainType(dto.getMainType())
                    .subType(dto.getSubType())
                    .build())
            .address(new Address(dto.getCity(), dto.getStreet(), dto.getZipCode()))
            .build();
  }

  public static ShopRegistrationResponse toRegistrationResponse(Shop shop) {
    return ShopRegistrationResponse.builder()
            .shopId(shop.getId())
            .vendorId(shop.getVendorId())
            .businessName(shop.getBusiness().getBusinessName())
            .businessHour(shop.getBusiness().getBusinessHour())
            .businessNumber(shop.getBusiness().getBusinessNumber())
            .mainType(shop.getBusiness().getMainType())
            .subType(shop.getBusiness().getSubType())
            .city(shop.getAddress().getCity())
            .street(shop.getAddress().getStreet())
            .zipCode(shop.getAddress().getZipCode())
            .build();
  }

  public static Shop toModificationRequest(ShopModificationRequest dto) {
    return Shop.builder()
            .minimumPrice(dto.getMinimumPrice())
            .deliveryFee(dto.getDeliveryFee())
            .business(new Business(dto.getBusinessHour()))
            .build();
  }

  public static ShopModificationResponse toModificationResponse(Shop shop) {
    return ShopModificationResponse.builder()
            .vendorId(shop.getVendorId())
            .shopId(shop.getId())
            .businessName(shop.getBusiness().getBusinessName())
            .businessHour(shop.getBusiness().getBusinessHour())
            .businessNumber(shop.getBusiness().getBusinessNumber())
            .mainType(shop.getBusiness().getMainType())
            .subType(shop.getBusiness().getSubType())
            .minimumPrice(shop.getMinimumPrice())
            .deliveryFee(shop.getDeliveryFee())
            .city(shop.getAddress().getCity())
            .street(shop.getAddress().getStreet())
            .zipCode(shop.getAddress().getZipCode())
            .build();
  }

  public static ShopRetrievalResponse toRetrievalResponse(Shop shop) {
    List<MenuRetrievalResponse> menus = shop.getMenus().stream()
            .map(menu -> toMenuRetrievalResponse(menu))
            .collect(Collectors.toList());

    return ShopRetrievalResponse.builder()
            .shopId(shop.getId())
            .vendorId(shop.getVendorId())
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
            .menus(menus)
            .build();
  }

  private static MenuRetrievalResponse toMenuRetrievalResponse(Menu menu) {
    List<OptionGroupRetrievalResponse> optionGroups = menu.getOptionGroups().stream()
            .map(og -> toOptionGroupRetrievalResponse(og))
            .collect(Collectors.toList());

    return MenuRetrievalResponse.builder()
            .id(menu.getId())
            .shopId(menu.getShop().getId())
            .categoryId(menu.getCategory().getId())
            .category(menu.getCategory().getType())
            .name(menu.getName())
            .description(menu.getDescription())
            .price(menu.getMoney().currentMoney())
            .soldYn(menu.getSoldYn())
            .useYn(menu.getUseYn())
            .optionGroups(optionGroups)
            .build();
  }

  private static OptionGroupRetrievalResponse toOptionGroupRetrievalResponse(OptionGroup optionGroup) {
    List<OptionRetrievalResponse> options = optionGroup.getOptions().stream()
            .map(o -> toOptionRetrievalResponse(o))
            .collect(Collectors.toList());

    return OptionGroupRetrievalResponse.builder()
            .id(optionGroup.getId())
            .menuId(optionGroup.getMenu().getId())
            .basicChoiceYn(optionGroup.getBasicChoiceYn())
            .etcChoiceYn(optionGroup.getEtcChoiceYn())
            .useYn(optionGroup.getUseYn())
            .options(options)
            .build();
  }

  private static OptionRetrievalResponse toOptionRetrievalResponse(Option option) {
    return OptionRetrievalResponse.builder()
            .id(option.getId())
            .optionGroupId(option.getOptionGroup().getId())
            .name(option.getName())
            .price(option.getPrice())
            .displayOrder(option.getDisplayOrder())
            .useYn(option.getUseYn())
            .build();
  }
}
