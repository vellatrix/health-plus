package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VendorRegistrationResponse {

  private Long vendorId;
  private String nickName;
  private String email;
  private String phoneNumber;
  private String name;
  private String bank;
  private String accountNumber;
  private Long userId;

}
