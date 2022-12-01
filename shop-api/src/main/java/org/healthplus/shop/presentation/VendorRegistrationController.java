package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorRegistrationService;
import org.healthplus.shop.presentation.convertor.VendorRequestDtoConvertor;
import org.healthplus.shop.presentation.dto.VendorRegistrationRequest;
import org.healthplus.shop.domain.entity.Vendor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorRegistrationController {

  private final VendorRegistrationService vendorRegistrationService;

  @PostMapping
  public ApiResponse<String> registerVendor(@RequestBody VendorRegistrationRequest dto) {

    Vendor vendor = VendorRequestDtoConvertor.toVendorRegistrationRequest(dto);
    Vendor savedVendor = vendorRegistrationService.registerVendor(vendor);
    if(savedVendor == null) return ApiResponse.success("success");
    else return ApiResponse.fail("0001", "fail");
  }
}
