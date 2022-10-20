package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoListDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOrderDTO;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

  private final MenuService menuService;

  @GetMapping("/{restaurantId}/{productId}/info")
  public ResponseEntity<ProductInfoInquiryDTO> getProductInfo(@PathVariable Long restaurantId,
                                                              @PathVariable Long productId) {

    return ResponseEntity.ok(menuService.getProduct(restaurantId, productId));
  }

  @GetMapping("/{restaurantId}/info")
  public ResponseEntity<List<ProductInfoListDTO>> getProductInfoList(@PathVariable Long restaurantId) {

    return ResponseEntity.ok(menuService.getProductList(restaurantId));

  }

  @PostMapping("/{restaurantId}/order")
  public ResponseEntity<ProductOrderDTO> orderProduct(@PathVariable Long restaurantId,
                                                      @RequestBody List<ProductInfoListDTO> productList) {

    // todo : 주문
    return ResponseEntity.ok(new ProductOrderDTO());
  }

  @PatchMapping("/{restaurantId}/{productId}")
  public ResponseEntity<Result> changeProductInfo(@PathVariable Long restaurantId,
                                                  @PathVariable Long productId,
                                                  @RequestBody ProductInfoListDTO productInfo) {

    return ResponseEntity.ok(menuService.updateProduct(restaurantId, productId, productInfo));

  }

  @PostMapping("/{restaurantId}/product")
  public ResponseEntity<List<ProductInfoRegistrationResultDTO>> addProductInfo(@PathVariable Long restaurantId,
                                                                               @RequestBody List<ProductInfoRegistrationDTO> productInfo) {

    return ResponseEntity.ok(menuService.registerProductInfo(restaurantId, productInfo));
  }

  @DeleteMapping("/{restaurantId}/{productId}")
  public ResponseEntity<Result> deleteProductInfo(@PathVariable Long restaurantId,
                                                  @PathVariable Long productId) {

    return ResponseEntity.ok(menuService.removeProductInfo(restaurantId, productId));

  }


}
