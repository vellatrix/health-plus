package org.healthplus.shop.application.dto;

import lombok.Getter;
import org.healthplus.shop.domain.shop.Category;
import org.healthplus.shop.domain.shop.Menu;
import org.healthplus.shop.domain.shop.Money;
import org.healthplus.shop.domain.shop.OptionGroup;
import org.healthplus.shop.domain.shop.enums.Type;

import java.util.List;
import java.util.stream.Collectors;


@Getter
public class MenuRegistrationData {

  private Integer categoryId;
  private Type type;
  private String name;
  private Integer price;
  private String description;
  private List<OptionGroupRegistrationData> optionGroups;

  public Menu toMenu() {
    List<OptionGroup> optionGroups = this.optionGroups.stream()
            .map(og -> og.toOptionGroup())
            .collect(Collectors.toList());

    return Menu.builder()
            .category(new Category(categoryId))
            .name(name)
            .price(new Money(price))
            .description(description)
            .type(type)
            .optionGroups(optionGroups)
            .build();
  }

}
