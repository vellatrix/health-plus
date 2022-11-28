package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.convertor.ShopResponseDataConvertor;
import org.healthplus.shop.application.dto.ShopRetrievalResponse;
import org.healthplus.shop.application.service.ShopRetrievalService;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopRetrievalController {

  private final ShopRetrievalService shopRetrievalService;

  @DeleteMapping("/{shopId}")
  public ApiResponse<ShopRetrievalResponse> getShop(@PathVariable Long shopId) {

    Shop shop = shopRetrievalService.retrieveShop(shopId);

    ShopRetrievalResponse responseData = ShopResponseDataConvertor.toShopRetrievalResponse(shop);

    return ApiResponse.success(responseData);
  }
}
