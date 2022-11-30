package org.healthplus.shop.domain.shop;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.shop.enums.IsYn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "options")
@Getter
public class Option {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "option_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "option_group_id")
  private OptionGroup optionGroup;

  private String name;
  private Money price;
  private Integer displayOrder;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  @Builder
  public Option(Long id, String name, Money price, Integer displayOrder) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
  }

  public Option(String name, Money price, Integer displayOrder) {
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
  }

  public void setOptionGroup(OptionGroup optionGroup) {
    this.optionGroup = optionGroup;
  }

  public void changeOption(Option option) {
    this.name = option.getName();
    this.price = option.getPrice();
    this.displayOrder = option.getDisplayOrder();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Option option = (Option) o;
    return Objects.equals(name, option.name) && Objects.equals(price, option.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price);
  }


}
