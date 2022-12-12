package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopCloseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop-close")
public class ShopCloseController {

  private final ShopCloseService shopCloseService;

  @GetMapping("/{shopId}")
  public ApiResponse<Void> closeShop(@PathVariable Long shopId) {

    shopCloseService.closeShop(shopId);

    return ApiResponse.success(null);
  }
}
