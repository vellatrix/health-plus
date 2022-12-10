package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorModificationService;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.presentation.convertor.VendorDtoConvertor;
import org.healthplus.shop.presentation.dto.request.VendorModificationRequest;
import org.healthplus.shop.presentation.dto.response.VendorModificationResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorModificationController {

  private final VendorModificationService vendorModificationService;

  @PatchMapping("/{vendorId}")
  public ApiResponse<VendorModificationResponse> modifyVendor(@PathVariable Long vendorId,
                                                              @RequestBody @Valid VendorModificationRequest dto) {
    Vendor vendor = VendorDtoConvertor.toVendorModificationRequest(dto);
    Vendor modifiedVendor = vendorModificationService.modifyVendor(vendorId, vendor);
    VendorModificationResponse responseData = VendorDtoConvertor.toVendorModificationResponse(modifiedVendor);

    return ApiResponse.success(responseData);
  }

}
