package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOrderDTO;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  public ProductInfoDTO getProduct(@PathVariable Long restaurantId,
                                   @PathVariable Long productId) {

    return menuService.getProduct(restaurantId, productId);
  }

  @GetMapping("/{restaurantId}/info")
  public List<ProductInfoDTO> getProductList(@PathVariable Long restaurantId) {

    return menuService.getProductList(restaurantId);

  }

  @PostMapping("/{restaurantId}/order")
  public ProductOrderDTO orderProduct(@PathVariable Long restaurantId,
                                      @RequestBody List<ProductInfoDTO> productList) {


    // restTemplateConfig.restTemplate().postForEntity()
    // 주문이 올 경우,
    // todo : 주문
    return new ProductOrderDTO();
  }

  @PatchMapping("/{restaurantId}/{productId}")
  public List<ProductInfoDTO> changeProduct(@PathVariable Long restaurantId,
                                            @PathVariable Long productId,
                                            @RequestBody ProductInfoDTO productInfo) {

    return menuService.updateProduct(restaurantId, productId, productInfo);

  }

  @PostMapping("/{restaurantId}/product")
  public List<ProductInfoRegistrationResultDTO> addProduct(@PathVariable Long restaurantId,
                                                           @RequestBody List<ProductInfoRegistrationDTO> productInfo) {

    return menuService.registerProductInfo(restaurantId, productInfo);
  }

  @DeleteMapping("/{restaurantId}/{productId}")
  public Result deleteProduct(@PathVariable Long restaurantId,
                              @PathVariable Long productId) {

    return menuService.removeProductInfo(restaurantId, productId);

  }


  @GetMapping("/category/products/{categoryId}")
  public Page<ProductInfoByCategoryDTO> getProductListByCategoryId(@PathVariable Long categoryId,
                                                                   Pageable pageable) {

    return menuService.getProductListByCategoryId(categoryId, pageable);
  }



}
