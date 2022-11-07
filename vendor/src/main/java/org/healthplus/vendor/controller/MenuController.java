package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationDTO;
import org.healthplus.vendor.dto.ProductInfoRegistrationResultDTO;
import org.healthplus.vendor.dto.ProductOrderDTO;
import org.healthplus.vendor.enums.ResponseMessageCode;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.MenuService;
import org.healthplus.vendor.util.MenuDataConvertor;
import org.healthplus.vendor.util.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.healthplus.vendor.enums.ResponseMessageCode.*;
import static org.healthplus.vendor.enums.Result.FAIL;
import static org.healthplus.vendor.enums.Result.SUCCESS;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {

  private final MenuService menuService;

  @GetMapping("/{restaurantId}/{productId}/info")
  public Response getProduct(@PathVariable Long restaurantId,
                                   @PathVariable Long productId) {

    ProductInfoDTO data = menuService.getProduct(restaurantId, productId);
    return Response.builder()
            .message(data == null ? INQUIRY_FAIL.getContent() : INQUIRY_SUCCESS.getContent())
            .status(data == null ? NO_CONTENT : OK)
            .data(data)
            .build();
  }

  @GetMapping("/{restaurantId}/info")
  public Response getProductList(@PathVariable Long restaurantId) {

    List<ProductInfoDTO> data = menuService.getProductList(restaurantId);
    return Response.builder()
            .message(data.size() == 0 ? INQUIRY_FAIL.getContent() : INQUIRY_SUCCESS.getContent())
            .status(data.size() == 0 ? NO_CONTENT : OK)
            .data(data)
            .build();
  }

  @PostMapping("/{restaurantId}/order")
  public Response orderProduct(@PathVariable Long restaurantId,
                               @RequestBody List<ProductInfoDTO> productList) {

    // todo : 주문
    return Response.builder()
            .message(null)
            .status(null)
            .data(null)
            .build();
  }

  @PatchMapping("/{restaurantId}/{productId}")
  public Response changeProduct(@PathVariable Long restaurantId,
                                @PathVariable Long productId,
                                @RequestBody ProductInfoDTO productInfo) {


    List<ProductInfoDTO> data = menuService.updateProduct(restaurantId, productId, productInfo);
    return Response.builder()
            .message(data.size() == 0 ? UPDATE_FAIL.getContent() : UPDATE_SUCCESS.getContent())
            .status(data.size() == 0 ? NO_CONTENT : OK)
            .data(data)
            .build();
  }

  @PostMapping("/{restaurantId}/product")
  public Response addProduct(@PathVariable Long restaurantId,
                             @RequestBody List<ProductInfoRegistrationDTO> productInfo) {


    List<ProductInfoRegistrationResultDTO> data = menuService.registerProductInfo(restaurantId, productInfo);
    return Response.builder()
            .message(data.size() == 0 ? REGISTER_FAIL.getContent() : REGISTER_SUCCESS.getContent())
            .status(data.size() == 0 ? NO_CONTENT : CREATED)
            .data(data)
            .build();
  }

  @DeleteMapping("/{restaurantId}/{productId}")
  public Response deleteProduct(@PathVariable Long restaurantId,
                                @PathVariable Long productId) {


    Result data = menuService.removeProductInfo(restaurantId, productId);

    return Response.builder()
            .message(data.equals(SUCCESS) ? DELETE_SUCCESS.getContent() : DELETE_FAIL.getContent())
            .status(data.equals(SUCCESS) ? NO_CONTENT : OK)
            .data(data)
            .build();
  }


  @GetMapping("/category/products/{categoryId}")
  public Response getProductListByCategoryId(@PathVariable Long categoryId,
                                                           Pageable pageable) {
    Page<ProductInfoByCategoryDTO> data = menuService.getProductListByCategoryId(categoryId, pageable);

    return Response.builder()
            .message(data.getTotalElements() == 0 ? INQUIRY_FAIL.getContent() : INQUIRY_SUCCESS.getContent())
            .status(data.getTotalElements() == 0 ? NO_CONTENT : OK)
            .data(data)
            .build();
  }
}
