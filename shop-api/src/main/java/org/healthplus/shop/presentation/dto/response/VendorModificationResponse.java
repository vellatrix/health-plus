package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VendorModificationResponse {

  private Long vendorId;
  private String name;
  private String nickName;
  private String email;
  private String phoneNumber;

}
