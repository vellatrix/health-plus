package org.healthplus.shop.domain.vendor;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Bank {

  private String bank;
  private String accountNumber;
}
