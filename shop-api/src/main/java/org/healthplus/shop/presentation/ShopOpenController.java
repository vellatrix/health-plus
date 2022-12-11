package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopOpenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop-open")
public class ShopOpenController {

  private final ShopOpenService shopOpenService;

  @GetMapping("/{shopId}")
  public ApiResponse<Void> openShop(@PathVariable Long shopId) {

    shopOpenService.openShop(shopId);

    return ApiResponse.success(null);
  }
}