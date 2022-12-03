package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.UserIdDomain;
import org.healthplus.shop.domain.VendorDomain;
import org.healthplus.shop.presentation.dto.request.VendorModificationRequest;
import org.healthplus.shop.presentation.dto.request.VendorRegistrationRequest;

public class VendorRequestDtoConvertor {

  public static VendorDomain toVendorRegistrationRequest(VendorRegistrationRequest dto) {
    return VendorDomain.builder()
            .nickName(dto.getNickName())
            .name(dto.getName())
            .email(dto.getEmail())
            .phoneNumber(dto.getPhoneNumber())
            .password(dto.getPassword())
            .userId(new UserIdDomain(dto.getUserId()))
            .build();
  }

  public static VendorDomain toVendorModificationRequest(VendorModificationRequest dto) {
    return VendorDomain.builder()
            .nickName(dto.getNickName())
            .email(dto.getEmail())
            .build();
  }
}
