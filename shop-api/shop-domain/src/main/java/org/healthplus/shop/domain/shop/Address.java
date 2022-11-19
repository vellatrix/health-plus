package org.healthplus.shop.domain.shop;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

  private String city;
  private String street;
  private String zipCode;
}
