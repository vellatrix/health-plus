package org.healthplus.shop.presentation.convertor;

import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.presentation.dto.request.VendorModificationRequest;
import org.healthplus.shop.presentation.dto.request.VendorRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.VendorModificationResponse;
import org.healthplus.shop.presentation.dto.response.VendorRegistrationResponse;
import org.healthplus.shop.presentation.dto.response.VendorRetrievalResponse;

public class VendorDtoConvertor {

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

  public static Vendor toVendorModificationRequest(VendorModificationRequest dto) {
    return Vendor.builder()
            .nickName(dto.getNickName())
            .email(dto.getEmail())
            .build();
  }

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

  public static VendorModificationResponse toVendorModificationResponse(Vendor vendor) {
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
