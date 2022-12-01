package org.healthplus.shop.presentation.dto;

import lombok.Getter;
import org.healthplus.shop.domain.entity.Vendor;

@Getter
public class VendorRegistrationRequest {

  private String nickName;
  private String email;
  private String phoneNumber;
  private String name;
  private String bank;
  private String accountNumber;
  private String password;
  private Long userId;

  public Vendor toVendor() {
    return Vendor.builder()
            .nickName(nickName)
            .name(name)
            .email(email)
            .phoneNumber(phoneNumber)
            .password(password)
            .userId(userId)
            .build();
  }


}
