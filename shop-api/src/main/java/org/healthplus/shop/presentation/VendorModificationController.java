package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorModificationService;
import org.healthplus.shop.domain.VendorDomain;
import org.healthplus.shop.presentation.convertor.VendorRequestDtoConvertor;
import org.healthplus.shop.presentation.convertor.VendorResponseDtoConvertor;
import org.healthplus.shop.presentation.dto.request.VendorModificationRequest;
import org.healthplus.shop.presentation.dto.response.VendorModificationResponse;
import org.healthplus.shop.domain.entity.Vendor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorModificationController {

  private final VendorModificationService vendorModificationService;

  @PatchMapping("/{vendorId}")
  public ApiResponse<VendorModificationResponse> modifyVendor(@PathVariable Long vendorId,
                                                              @RequestBody @Validated VendorModificationRequest dto) {

    VendorDomain vendorDomain = VendorRequestDtoConvertor.toVendorModificationRequest(dto);
    VendorDomain modifiedVendor = vendorModificationService.modifyVendor(vendorId, vendorDomain);
    VendorModificationResponse responseData = VendorResponseDtoConvertor.toVendorModificationResponse(modifiedVendor);

    return ApiResponse.success(responseData);
  }

}
