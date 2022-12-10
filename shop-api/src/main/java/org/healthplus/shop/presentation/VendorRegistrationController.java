package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorRegistrationService;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.presentation.convertor.VendorDtoConvertor;
import org.healthplus.shop.presentation.dto.request.VendorRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.VendorRegistrationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorRegistrationController {

  private final VendorRegistrationService vendorRegistrationService;

  @PostMapping
  public ApiResponse<VendorRegistrationResponse> registerVendor(@RequestBody @Valid VendorRegistrationRequest dto) {
    Vendor vendor = VendorDtoConvertor.toVendorRegistrationRequest(dto);
    Vendor savedVendor = vendorRegistrationService.registerVendor(vendor);
    VendorRegistrationResponse responseData = VendorDtoConvertor.toVendorRegistrationResponse(savedVendor);

    return ApiResponse.success(responseData);
  }
}
