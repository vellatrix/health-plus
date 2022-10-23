package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOrderDTO;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.dto.VendorProfileInquiryDTO;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.dto.VendorRegistrationResultDTO;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

  private final VendorService vendorService;

  @GetMapping("/{vendorId}/profile")
  public ResponseEntity<VendorProfileInquiryDTO> getVendorProfile(@PathVariable Long vendorId) {

    return ResponseEntity.ok(vendorService.getVendorProfile(vendorId));
  }

  @DeleteMapping("/{vendorId}")
  public ResponseEntity<Result> removeVendorInfo(@PathVariable Long vendorId) {
    return ResponseEntity.ok(vendorService.removeVendor(vendorId));
  }

  @PostMapping
  public ResponseEntity<VendorRegistrationResultDTO> addVendor(@RequestBody VendorRegistrationDTO dto) {
    return ResponseEntity.ok(vendorService.registerVendor(dto));
  }


}
