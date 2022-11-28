package org.healthplus.shop.application.dto;

import lombok.Getter;
import org.healthplus.shop.domain.shop.Money;
import org.healthplus.shop.domain.shop.Option;

@Getter
public class OptionRegistrationData {

  private String name;
  private Integer price;
  private Integer displayOrder;

  public OptionRegistrationData(String name, Integer price, Integer displayOrder) {
    this.name = name;
    this.price = price;
    this.displayOrder = displayOrder;
  }

  public Option toOption() {
    return new Option(name, new Money(price), displayOrder);
  }

}
