package org.healthplus.shop.presentation;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.shop.application.service.ShopRetrievalService;
import org.healthplus.shop.application.service.VendorRetrievalService;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.presentation.convertor.ShopDtoConvertor;
import org.healthplus.shop.presentation.dto.response.ShopRetrievalResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendors")
public class ShopRetrievalController {

  private final ShopRetrievalService shopRetrievalService;
  private final VendorRetrievalService vendorRetrievalService;

  @GetMapping("/vendors/{vendorId}/shops/{shopId}")
  public ApiResponse<ShopRetrievalResponse> retrieveShop(@PathVariable Long vendorId,
                                                         @PathVariable Long shopId) {

    vendorRetrievalService.retrieveVendor(vendorId);
    Shop shop = shopRetrievalService.retrieveShop(shopId);
    ShopRetrievalResponse responseData = ShopDtoConvertor.toRetrievalResponse(shop);

    return ApiResponse.success(responseData);
  }

  @GetMapping("/vendors/{vendorId}/shops")
  public ApiResponse<List<ShopRetrievalResponse>> retrieveShops(@PathVariable Long vendorId) {

    vendorRetrievalService.retrieveVendor(vendorId);
    List<Shop> shops = shopRetrievalService.retrieveShops(vendorId);
    List<ShopRetrievalResponse> responseDataList = new ArrayList<>();
    shops.forEach(shop -> responseDataList.add(ShopDtoConvertor.toRetrievalResponse(shop)));

    return ApiResponse.success(responseDataList);
  }

  @GetMapping("/categories/{categoryId}")
  public ApiResponse<List<ShopRetrievalResponse>> retrieveShopsByCategoryId(@PathVariable Integer categoryId) {

    List<Shop> shops = shopRetrievalService.retrieveShopsWithCategory(categoryId);
    List<ShopRetrievalResponse> responseDataList = new ArrayList<>();
    shops.forEach(shop -> responseDataList.add(ShopDtoConvertor.toRetrievalResponse(shop)));

    return ApiResponse.success(responseDataList);
  }
}
