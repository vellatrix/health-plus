package org.healthplus.shop.domain.shop;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Money {

  private Integer value;

  public Money(Integer value) {
    this.value = value;
  }

  public Integer currentMoney() {
    return this.value;
  }

  public void plus(Money money) {
    this.value += money.getValue();
  }

  public void minus(Money money) {
    this.value -= money.getValue();
  }

}
