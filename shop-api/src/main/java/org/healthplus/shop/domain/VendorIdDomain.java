package org.healthplus.shop.domain;

import lombok.Getter;

@Getter
public class VendorIdDomain {

  private Long vendorId;

  public VendorIdDomain(Long vendorId) {
    this.vendorId = vendorId;
  }
}
