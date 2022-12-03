package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorRegistrationService;
import org.healthplus.shop.domain.VendorDomain;
import org.healthplus.shop.presentation.convertor.VendorRequestDtoConvertor;
import org.healthplus.shop.presentation.convertor.VendorResponseDtoConvertor;
import org.healthplus.shop.presentation.dto.request.VendorRegistrationRequest;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.presentation.dto.response.VendorRegistrationResponse;
import org.springframework.validation.annotation.Validated;
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
  public ApiResponse<VendorRegistrationResponse> registerVendor(@RequestBody @Validated VendorRegistrationRequest dto) {

    VendorDomain vendor = VendorRequestDtoConvertor.toVendorRegistrationRequest(dto);
    Vendor savedVendor = vendorRegistrationService.registerVendor(vendor);
    VendorRegistrationResponse responseData = VendorResponseDtoConvertor.toVendorRegistrationResponse(savedVendor);

    return ApiResponse.success(responseData);
  }
}
