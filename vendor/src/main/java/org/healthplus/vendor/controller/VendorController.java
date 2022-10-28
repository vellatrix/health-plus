package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.VendorProfileInquiryDTO;
import org.healthplus.vendor.dto.VendorRegistrationDTO;
import org.healthplus.vendor.dto.VendorRegistrationResultDTO;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.VendorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

  private final VendorService vendorService;

  @GetMapping("/{vendorId}/profile")
  public VendorProfileInquiryDTO getVendorProfile(@PathVariable Long vendorId) {

    return vendorService.getVendorProfile(vendorId);
  }

  @DeleteMapping("/{vendorId}")
  public Result removeVendorInfo(@PathVariable Long vendorId) {
    return vendorService.removeVendor(vendorId);
  }

  @PostMapping
  public VendorRegistrationResultDTO addVendor(@RequestBody VendorRegistrationDTO dto) {
    return vendorService.registerVendor(dto);
  }


}
