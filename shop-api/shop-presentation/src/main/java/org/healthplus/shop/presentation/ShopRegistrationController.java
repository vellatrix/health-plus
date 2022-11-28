package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.convertor.ShopResponseDataConvertor;
import org.healthplus.shop.application.dto.ShopRegistrationRequest;
import org.healthplus.shop.application.dto.ShopRegistrationResponse;
import org.healthplus.shop.application.service.ShopRegistrationService;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopRegistrationController {

  private final ShopRegistrationService shopRegistrationService;

  @PostMapping
  public ApiResponse<ShopRegistrationResponse> registerShop(@RequestBody ShopRegistrationRequest dto) {

    Shop shop = dto.toShop();
    Shop savedShop = shopRegistrationService.registerShop(shop);
    ShopRegistrationResponse responseData = ShopResponseDataConvertor.toShopRegistrationResponse(savedShop);

    return ApiResponse.success(responseData);
  }
}
