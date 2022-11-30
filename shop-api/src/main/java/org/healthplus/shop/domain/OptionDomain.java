package org.healthplus.shop.domain;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.entity.enums.IsYn;

import java.util.Objects;

@Getter
public class OptionDomain {

  private Long id;
  private OptionGroupDomain optionGroup;
  private String name;
  private MoneyDomain price;
  private Integer displayOrder;
  private IsYn useYn;

  @Builder
  public OptionDomain(Long id, String name, MoneyDomain price, Integer displayOrder) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
  }

  public OptionDomain(String name, MoneyDomain price, Integer displayOrder) {
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
  }

  public void setOptionGroup(OptionGroupDomain optionGroup) {
    this.optionGroup = optionGroup;
  }

  public void changeOption(OptionDomain option) {
    this.name = option.getName();
    this.price = option.getPrice();
    this.displayOrder = option.getDisplayOrder();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OptionDomain option = (OptionDomain) o;
    return Objects.equals(name, option.name) && Objects.equals(price, option.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }


}
