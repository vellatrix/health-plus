package org.healthplus.shop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Embeddable
public class Money {

  private Integer price;

  public Integer currentMoney() {
    return this.price;
  }

  public void plus(Integer amount) {
    this.price += amount;
  }

  public void minus(Integer amount) {
    this.price -= amount;
  }
}
