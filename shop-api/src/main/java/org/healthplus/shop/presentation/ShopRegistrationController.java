package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopRegistrationService;
import org.healthplus.shop.application.service.VendorRetrievalService;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.presentation.convertor.ShopDtoConvertor;
import org.healthplus.shop.presentation.dto.request.ShopRegistrationRequest;
import org.healthplus.shop.presentation.dto.response.ShopRegistrationResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class ShopRegistrationController {

  private final ShopRegistrationService shopRegistrationService;
  private final VendorRetrievalService vendorRetrievalService;

  @PostMapping("/{vendorId}/shops")
  public ApiResponse<ShopRegistrationResponse> registerShop(@PathVariable Long vendorId,
                                                            @RequestBody @Valid ShopRegistrationRequest dto) {
    vendorRetrievalService.retrieveVendor(vendorId);
    Shop shop = ShopDtoConvertor.toRegistrationRequest(vendorId, dto);
    Shop savedShop = shopRegistrationService.registerShop(shop);
    ShopRegistrationResponse responseData = ShopDtoConvertor.toRegistrationResponse(savedShop);

    return ApiResponse.success(responseData);
  }
}
