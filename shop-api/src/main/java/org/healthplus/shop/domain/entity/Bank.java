package org.healthplus.shop.domain.entity;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Bank {

  private String bank;
  private String accountNumber;

  public Bank(String bank, String accountNumber) {
    this.bank = bank;
    this.accountNumber = accountNumber;
  }
}
