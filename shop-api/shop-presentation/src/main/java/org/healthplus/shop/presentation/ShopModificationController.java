package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.convertor.ShopResponseDataConvertor;
import org.healthplus.shop.application.dto.ShopModificationRequest;
import org.healthplus.shop.application.dto.ShopModificationResponse;
import org.healthplus.shop.application.service.ShopModificationService;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopModificationController {

  private final ShopModificationService shopModificationService;

  @PatchMapping("/{shopId}")
  public ApiResponse<ShopModificationResponse> modifyShop(@PathVariable Long shopId,
                                   @RequestBody ShopModificationRequest dto) {
    Shop shop = dto.toShop(shopId);
    Shop modifiedShop = shopModificationService.modifyShop(shop);

    ShopModificationResponse responseData = ShopResponseDataConvertor.toShopModificationResponse(modifiedShop);

    return ApiResponse.success(responseData);
  }

}
