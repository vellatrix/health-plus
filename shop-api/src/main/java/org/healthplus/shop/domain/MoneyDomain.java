package org.healthplus.shop.domain;

import lombok.Getter;

@Getter
public class MoneyDomain {

  private Integer value;

  public MoneyDomain(Integer value) {
    this.value = value;
  }

  public Integer currentMoney() {
    return this.value;
  }

  public void plus(MoneyDomain money) {
    this.value += money.getValue();
  }

  public void minus(MoneyDomain money) {
    this.value -= money.getValue();
  }

}
