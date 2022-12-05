package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.CategoryDomain;
import org.healthplus.shop.domain.MenuDomain;
import org.healthplus.shop.domain.MoneyDomain;
import org.healthplus.shop.domain.OptionDomain;
import org.healthplus.shop.domain.OptionGroupDomain;
import org.healthplus.shop.domain.ShopDomain;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.enums.Type;
import org.healthplus.shop.presentation.dto.request.MenuModificationRequest;
import org.healthplus.shop.presentation.dto.request.MenuRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.MenuModificationResponse;
import org.healthplus.shop.presentation.dto.response.MenuRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.OptionGroupModificationResponse;
import org.healthplus.shop.presentation.dto.response.OptionGroupRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.OptionModificationResponse;
import org.healthplus.shop.presentation.dto.response.OptionRegistrationResponse;

import java.util.stream.Collectors;

public class MenuDtoConvertor {

  public static MenuDomain toMenuRegistrationRequest(MenuRegistrationRequest dto) {
    return MenuDomain.builder()
            .shop(new ShopDomain(dto.getShopId()))
            .category(new CategoryDomain(dto.getCategoryId()))
            .name(dto.getName())
            .type(dto.getType())
            .price(new MoneyDomain(dto.getPrice()))
            .description(dto.getDescription())
            .optionGroups(dto.getOptionGroups().stream()
                            .map(og -> OptionGroupDomain.builder()
                                        .basicChoiceYn(og.getBasicChoiceYn())
                                        .etcChoiceYn(og.getEtcChoiceYn())
                                        .options(og.getOptions().stream()
                                        .map(o -> OptionDomain.builder()
                                                    .name(o.getName())
                                                    .price(new MoneyDomain(o.getPrice()))
                                                    .displayOrder(o.getDisplayOrder())
                                                    .build()).collect(Collectors.toList()))
                            .build())
                            .collect(Collectors.toList()))
            .build();

  }

  public static MenuRegistrationResponse toMenuRegistrationResponse(Menu menu) {
    return MenuRegistrationResponse.builder()
            .id(menu.getId())
            .shopId(menu.getShop().getId())
            .categoryId(menu.getCategory().getId())
            .category(menu.getCategory().getType())
            .name(menu.getName())
            .description(menu.getDescription())
            .price(menu.getPrice())
            .optionGroups(menu.getOptionGroups().stream()
            .map(og -> OptionGroupRegistrationResponse.builder()
                        .menuId(og.getMenu().getId())
                        .id(og.getId())
                        .basicChoiceYn(og.getBasicChoiceYn())
                        .etcChoiceYn(og.getEtcChoiceYn())
                        .useYn(og.getUseYn())
                        .options(og.getOptions().stream()
                                  .map(o -> OptionRegistrationResponse.builder()
                                            .optionGroupId(o.getOptionGroup().getId())
                                            .id(o.getId())
                                            .name(o.getName())
                                            .price(o.getPrice())
                                            .displayOrder(o.getDisplayOrder())
                                            .useYn(o.getUseYn())
                                            .build())
                                  .collect(Collectors.toList()))
                        .build())
                        .collect(Collectors.toList()))
            .build();

  }

  public static MenuDomain toMenuModificationRequest(MenuModificationRequest dto) {
    return MenuDomain.builder()
            .id(dto.getId())
            .name(dto.getName())
            .type(dto.getType().equals("A") ? Type.A : Type.B)
            .price(new MoneyDomain(dto.getPrice()))
            .description(dto.getDescription())
            .optionGroups(dto.getOptionGroups().stream()
                    .map(og -> OptionGroupDomain.builder()
                            .id(og.getId())
                            .basicChoiceYn(og.getBasicChoiceYn())
                            .etcChoiceYn(og.getEtcChoiceYn())
                            .useYn(og.getUseYn())
                            .options(og.getOptions().stream()
                                    .map(o -> OptionDomain.builder()
                                            .id(o.getId())
                                            .name(o.getName())
                                            .price(new MoneyDomain(o.getPrice()))
                                            .displayOrder(o.getDisplayOrder())
                                            .useYn(o.getUseYn())
                                            .build())
                                    .collect(Collectors.toList()))
                            .build())
                    .collect(Collectors.toList()))
            .build();
  }

  public static MenuModificationResponse toMenuModificationResponse(Menu menu) {
    return MenuModificationResponse.builder()
            .id(menu.getId())
            .shopId(menu.getShop().getId())
            .categoryId(menu.getCategory().getId())
            .category(menu.getCategory().getType())
            .name(menu.getName())
            .description(menu.getDescription())
            .price(menu.getPrice())
            .optionGroups(menu.getOptionGroups().stream()
                    .map(og -> OptionGroupModificationResponse.builder()
                            .menuId(og.getMenu().getId())
                            .id(og.getId())
                            .basicChoiceYn(og.getBasicChoiceYn())
                            .etcChoiceYn(og.getEtcChoiceYn())
                            .useYn(og.getUseYn())
                            .options(og.getOptions().stream()
                                    .map(o -> OptionModificationResponse.builder()
                                            .optionGroupId(o.getOptionGroup().getId())
                                            .id(o.getId())
                                            .name(o.getName())
                                            .price(o.getPrice())
                                            .displayOrder(o.getDisplayOrder())
                                            .useYn(o.getUseYn())
                                            .build())
                                    .collect(Collectors.toList()))
                            .build())
                    .collect(Collectors.toList()))
            .build();
  }
}
