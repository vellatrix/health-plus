package org.healthplus.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {

  private String city;
  private String street;

  @Column(name = "zip_code")
  @Nullable
  private Integer zipCode;

  public Address(String city, String street, Integer zipCode) {
    this.city = city;
    this.street = street;
    this.zipCode = zipCode;
  }
}
