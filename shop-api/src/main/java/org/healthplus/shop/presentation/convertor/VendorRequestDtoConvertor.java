package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.presentation.dto.VendorRegistrationRequest;

public class VendorRequestDtoConvertor {

  public static Vendor toVendorRegistrationRequest(VendorRegistrationRequest dto) {
    return Vendor.builder()
            .nickName(dto.getNickName())
            .name(dto.getName())
            .email(dto.getEmail())
            .phoneNumber(dto.getPhoneNumber())
            .password(dto.getPassword())
            .userId(dto.getUserId())
            .build();
  }
}
