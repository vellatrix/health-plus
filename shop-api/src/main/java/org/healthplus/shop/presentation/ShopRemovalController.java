package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopRemovalService;
import org.healthplus.shop.application.service.VendorRetrievalService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class ShopRemovalController {

  private final ShopRemovalService shopRemovalService;
  private final VendorRetrievalService vendorRetrievalService;

  @DeleteMapping("/{vendorId}/shops/{shopId}")
  public ApiResponse<String> removeShop(@PathVariable Long vendorId,
                                        @PathVariable Long shopId) {
    vendorRetrievalService.retrieveVendor(vendorId);
    shopRemovalService.removeShop(vendorId, shopId);

    return ApiResponse.success("success");
  }
}
