package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.entity.Category;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Money;
import org.healthplus.shop.domain.entity.Option;
import org.healthplus.shop.domain.entity.OptionGroup;
import org.healthplus.shop.domain.enums.Type;
import org.healthplus.shop.presentation.dto.request.MenuModificationRequest;
import org.healthplus.shop.presentation.dto.request.MenuRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.MenuModificationResponse;
import org.healthplus.shop.presentation.dto.response.MenuRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.MenuRetrievalResponse;
import org.healthplus.shop.presentation.dto.response.OptionGroupModificationResponse;
import org.healthplus.shop.presentation.dto.response.OptionGroupRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.OptionGroupRetrievalResponse;
import org.healthplus.shop.presentation.dto.response.OptionModificationResponse;
import org.healthplus.shop.presentation.dto.response.OptionRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.OptionRetrievalResponse;

import java.util.stream.Collectors;

public class MenuDtoConvertor {

  public static Menu toMenuRegistrationRequest(MenuRegistrationRequest dto) {
    return Menu.builder()
            .category(new Category(dto.getCategoryId()))
            .name(dto.getName())
            .type(dto.getType())
            .money(new Money(dto.getPrice()))
            .description(dto.getDescription())
            .optionGroups(dto.getOptionGroups().stream()
                            .map(og -> OptionGroup.builder()
                                        .basicChoiceYn(og.getBasicChoiceYn())
                                        .etcChoiceYn(og.getEtcChoiceYn())
                                        .options(og.getOptions().stream()
                                        .map(o -> Option.builder()
                                                    .name(o.getName())
                                                    .price(o.getPrice())
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
            .price(menu.getMoney().currentMoney())
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

  public static Menu toMenuModificationRequest(MenuModificationRequest dto) {
    return Menu.builder()
            .id(dto.getId())
            .name(dto.getName())
            .type(dto.getType().equals("A") ? Type.A : Type.B)
            .money(new Money(dto.getPrice()))
            .description(dto.getDescription())
            .optionGroups(dto.getOptionGroups().stream()
                    .map(og -> OptionGroup.builder()
                            .id(og.getId())
                            .basicChoiceYn(og.getBasicChoiceYn())
                            .etcChoiceYn(og.getEtcChoiceYn())
                            .useYn(og.getUseYn())
                            .options(og.getOptions().stream()
                                    .map(o -> Option.builder()
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

  public static MenuModificationResponse toMenuModificationResponse(Menu menu) {
    return MenuModificationResponse.builder()
            .id(menu.getId())
            .shopId(menu.getShop().getId())
            .categoryId(menu.getCategory().getId())
            .category(menu.getCategory().getType())
            .name(menu.getName())
            .description(menu.getDescription())
            .price(menu.getMoney().currentMoney())
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

  public static MenuRetrievalResponse toMenuRetrievalResponse(Menu menu) {
    return MenuRetrievalResponse.builder()
            .id(menu.getId())
            .shopId(menu.getShop().getId())
            .categoryId(menu.getCategory().getId())
            .category(menu.getCategory().getType())
            .name(menu.getName())
            .description(menu.getDescription())
            .price(menu.getMoney().currentMoney())
            .optionGroups(menu.getOptionGroups().stream()
                    .map(og -> OptionGroupRetrievalResponse.builder()
                            .menuId(og.getMenu().getId())
                            .id(og.getId())
                            .basicChoiceYn(og.getBasicChoiceYn())
                            .etcChoiceYn(og.getEtcChoiceYn())
                            .useYn(og.getUseYn())
                            .options(og.getOptions().stream()
                                    .map(o -> OptionRetrievalResponse.builder()
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
