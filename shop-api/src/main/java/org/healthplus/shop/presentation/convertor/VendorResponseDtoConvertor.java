package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.VendorDomain;
import org.healthplus.shop.presentation.dto.response.VendorModificationResponse;
import org.healthplus.shop.presentation.dto.response.VendorRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.VendorRetrievalResponse;
import org.healthplus.shop.domain.entity.Vendor;

public class VendorResponseDtoConvertor {

  public static VendorRetrievalResponse toVendorRetrievalResponse(Vendor vendor) {
    return VendorRetrievalResponse.builder()
            .vendorId(vendor.getId())
            .name(vendor.getName())
            .email(vendor.getEmail())
            .phoneNumber(vendor.getPhoneNumber())
            .bank(vendor.getBank().getBank())
            .accountNumber(vendor.getBank().getAccountNumber())
            .build();
  }

  public static VendorModificationResponse toVendorModificationResponse(VendorDomain vendor) {
    return VendorModificationResponse.builder()
            .vendorId(vendor.getId())
            .name(vendor.getName())
            .email(vendor.getEmail())
            .phoneNumber(vendor.getPhoneNumber())
            .nickName(vendor.getNickName())
            .build();
  }

  public static VendorRegistrationResponse toVendorRegistrationResponse(Vendor vendor) {
    return VendorRegistrationResponse.builder()
            .vendorId(vendor.getId())
            .name(vendor.getName())
            .email(vendor.getEmail())
            .phoneNumber(vendor.getPhoneNumber())
            .nickName(vendor.getNickName())
            .bank(vendor.getBank().getBank())
            .accountNumber(vendor.getBank().getAccountNumber())
            .userId(vendor.getUserId())
            .build();
  }
}
