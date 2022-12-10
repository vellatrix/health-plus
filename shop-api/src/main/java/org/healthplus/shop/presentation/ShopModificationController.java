package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopModificationService;
import org.healthplus.shop.application.service.VendorRetrievalService;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.presentation.convertor.ShopDtoConvertor;
import org.healthplus.shop.presentation.dto.request.ShopModificationRequest;
import org.healthplus.shop.presentation.dto.response.ShopModificationResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class ShopModificationController {

  private final ShopModificationService shopModificationService;
  private final VendorRetrievalService vendorRetrievalService;

  @PatchMapping("/{vendorId}/shops/{shopId}")
  public ApiResponse<ShopModificationResponse> modifyShop(@PathVariable Long vendorId,
                                                          @PathVariable Long shopId,
                                                          @RequestBody @Valid ShopModificationRequest dto) {

    vendorRetrievalService.retrieveVendor(vendorId);
    Shop shop = ShopDtoConvertor.toModificationRequest(dto);
    Shop modifiedShop = shopModificationService.modifyShop(shopId, shop);
    ShopModificationResponse responseData = ShopDtoConvertor.toModificationResponse(shop);

    return ApiResponse.success(responseData);
  }
}
