package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;
import org.healthplus.shop.domain.entity.Vendor;

@Getter
public class VendorModificationRequest {

  private String nickName;
  private String email;

}
