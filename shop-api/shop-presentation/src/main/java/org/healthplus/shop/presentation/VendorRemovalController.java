package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.VendorRemovalService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class VendorRemovalController {

  private final VendorRemovalService vendorRemovalService;

  @DeleteMapping("/{vendorId}")
  public ApiResponse<String> removeVendor(@PathVariable Long vendorId) {

    vendorRemovalService.removeVendor(vendorId);

    return ApiResponse.success("success");
  }
}
