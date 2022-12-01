package org.healthplus.shop.presentation.dto;

import lombok.Getter;
import org.healthplus.shop.domain.entity.Vendor;

@Getter
public class VendorModificationRequest {

  private Long vendorId;
  private String nickName;
  private String email;

  public Vendor toVendor() {
    return new Vendor(vendorId, nickName, email);
  }

}
