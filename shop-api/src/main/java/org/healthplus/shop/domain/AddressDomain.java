package org.healthplus.shop.domain;

import lombok.Getter;

@Getter
public class AddressDomain {

  private String city;
  private String street;
  private String zipCode;

  public AddressDomain(String city, String street, String zipCode) {
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
