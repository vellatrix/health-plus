package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.entity.Category;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Option;
import org.healthplus.shop.domain.entity.OptionGroup;
import org.healthplus.shop.domain.exception.OptionGroupNotFoundException;
import org.healthplus.shop.domain.enums.IsYn;
import org.healthplus.shop.domain.enums.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
  public MenuDomain(Long id,
                    String name,
                    Type type,
                    MoneyDomain price,
                    String description,
                    List<OptionGroupDomain> optionGroups,
                    CategoryDomain category,
                    ShopDomain shop) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.price = price;
    this.description = description;
    this.optionGroups = optionGroups;
    this.category = category;
    this.shop = shop;
  }


  public MenuDomain() {

  }

  public Menu addMenu(Long shopId) {
    return Menu.builder()
            .shopId(shopId)
            .name(name)
            .type(type)
            .price(price.currentMoney())
            .description(description)
            .category(new Category(category.getId()))
            .optionGroups(optionGroups.stream()
                            .map(og -> OptionGroup.builder()
                                    .basicChoiceYn(og.getBasicChoiceYn())
                                    .etcChoiceYn(og.getEtcChoiceYn())
                                    .options(og.getOptions().stream()
                                    .map(o -> Option.builder()
                                                .name(o.getName())
                                                .price(o.getPrice().currentMoney())
                                                .displayOrder(o.getDisplayOrder())
                                                .build()).collect(Collectors.toList()))
                            .build())
                            .collect(Collectors.toList()))
            .build();

  }

  public void checkValidCategory() {
    if(this.category == null) throw new IllegalStateException("존재하지 않는 카테고리입니다.");
  }

  public OptionGroupDomain findOptionGroup(Long optionGroupId) {
    return this.optionGroups.stream()
            .filter(og -> og.getId() == optionGroupId)
            .findFirst()
            .orElseThrow(OptionGroupNotFoundException::new);
  }

  public void changeMenu(Menu menu) {
    menu.setName(name);
    menu.setType(type);
    menu.setPrice(price.currentMoney());
    menu.setDescription(description);
    menu.getOptionGroups().forEach(entity -> {
      optionGroups.forEach(optionGroupDomain -> {
        if(optionGroupDomain.getId() == entity.getId()) optionGroupDomain.changeOptionGroup(entity);
      });
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
