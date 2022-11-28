package org.healthplus.shop.application.dto;

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
