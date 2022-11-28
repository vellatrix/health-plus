package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopRemovalService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopRemovalController {

  private final ShopRemovalService shopRemovalService;

  @DeleteMapping("/{shopId}")
  public ApiResponse<String> removeShop(@PathVariable Long shopId) {

    shopRemovalService.removeShop(shopId);

    return ApiResponse.success("success");
  }

}
