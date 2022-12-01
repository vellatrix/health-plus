package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.exception.OptionGroupNotFoundException;
import org.healthplus.shop.domain.enums.IsYn;
import org.healthplus.shop.domain.enums.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class MenuDomain {

  private Long id;
  private String name;
  private Type type;
  private MoneyDomain price;
  private String description;
  private List<OptionGroupDomain> optionGroups = new ArrayList<>();
  private ShopDomain shop;
  private CategoryDomain category;
  private IsYn soldYn;
  private IsYn useYn;

  @Builder
  public MenuDomain(Long id, String name, Type type, MoneyDomain price, String description, List<OptionGroupDomain> optionGroups, CategoryDomain category) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
    this.description = description;
    this.optionGroups = optionGroups;
    this.category = category;
  }

  @Builder
  public MenuDomain(String name, Type type, MoneyDomain price, String description, List<OptionGroupDomain> optionGroups, CategoryDomain category) {
    this.name = name;
    this.type = type;
    this.price = price;
    this.description = description;
    this.optionGroups = optionGroups;
    this.category = category;
  }

  public MenuDomain() {

  }

  public void checkValidCategory() {
    if(this.category == null) throw new IllegalStateException("존재하지 않는 카테고리입니다.");
  }

  public void setShop(ShopDomain shop) {
    this.shop = shop;
  }

  public void addOptionGroup(OptionGroupDomain optionGroup) {
    this.optionGroups.add(optionGroup);
    optionGroup.setMenu(this);
  }

  public OptionGroupDomain findOptionGroup(Long optionGroupId) {
    return this.optionGroups.stream()
            .filter(og -> og.getId() == optionGroupId)
            .findFirst()
            .orElseThrow(OptionGroupNotFoundException::new);
  }

  public void changeMenu(MenuDomain menu) {
    this.name = menu.getName();
    this.type = menu.getType();
    this.price = menu.getPrice();
    this.description = menu.getDescription();

    this.optionGroups.forEach(innerOptionGroup -> {
      OptionGroupDomain optionGroup = menu.getOptionGroups().stream()
              .filter(outerOptionGroup -> innerOptionGroup.getId() == outerOptionGroup.getId())
              .findAny()
              .orElseThrow(OptionGroupNotFoundException::new);

      innerOptionGroup.changeOptionGroup(optionGroup);
    });

  }

  public void deleteOptionGroup(Long optionGroupId) {
    OptionGroupDomain optionGroup = findOptionGroup(optionGroupId);
    this.optionGroups.remove(optionGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MenuDomain menu = (MenuDomain) o;
    return Objects.equals(id, menu.id) && Objects.equals(name, menu.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

}
