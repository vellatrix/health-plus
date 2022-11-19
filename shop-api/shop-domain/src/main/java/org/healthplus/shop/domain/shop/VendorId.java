package org.healthplus.shop.domain.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@AllArgsConstructor
@Embeddable
public class VendorId {

  private Long vendorId;
}
