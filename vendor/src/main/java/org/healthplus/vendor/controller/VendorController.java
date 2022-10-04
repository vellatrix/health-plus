package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.*;
import org.healthplus.vendor.enums.Result;
import org.healthplus.vendor.service.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendor")
@RequiredArgsConstructor
public class VendorController {

  private final VendorService vendorService;

  @GetMapping("/{vendorId}/{productId}/info")
  public ResponseEntity<ProductInfoInquiryDTO> getProductInfo(@PathVariable Long vendorId,
                                                              @PathVariable Long productId) {

    return ResponseEntity.ok(vendorService.getProduct(vendorId, productId));
  }

  @GetMapping("/{vendorId}/info")
  public ResponseEntity<RestaurantInfoInquiryDTO> getRestaurantInfo(@PathVariable Long vendorId) {

    return ResponseEntity.ok(vendorService.getRestaurant(vendorId));
  }

  @PostMapping("/{vendorId}/{productId}/order")
  public ResponseEntity<ProductOrderDTO> orderProduct(@PathVariable Long vendorId,
                                                      @PathVariable Long productId) {

    // todo : 주문
    return ResponseEntity.ok(new ProductOrderDTO());
  }

  @PutMapping("/{vendorId}/{productId}")
  public ResponseEntity<Result> changeProductInfo(@PathVariable Long vendorId,
                                                  @PathVariable Long productId,
                                                  @RequestBody ProductInfoDTO productInfo) {

    return ResponseEntity.ok(vendorService.updateProduct(vendorId, productId, productInfo));

  }

  @PostMapping("/{restaurantId}/product")
  public ResponseEntity<ProductInfoRegistrationResultDTO> addProductInfo(@PathVariable Long restaurantId,
                                                                         @RequestBody ProductInfoRegistrationDTO productInfo) {

    return ResponseEntity.ok(vendorService.registerProductInfo(restaurantId, productInfo));
  }

  @GetMapping("/{vendorId}/profile")
  public ResponseEntity<VendorProfileInquiryDTO> getVendorProfile(@PathVariable Long vendorId) {

    return ResponseEntity.ok(vendorService.getVendorProfile(vendorId));
  }

  @DeleteMapping("/{vendorId}")
  public ResponseEntity<Result> removeVendorInfo(@PathVariable Long vendorId) {
    return ResponseEntity.ok(vendorService.removeVendor(vendorId));
  }

  @PostMapping
  public ResponseEntity<VendorRegistrationResultDTO> addVendor(@RequestBody VendorRegistrationDTO dto) {
    return ResponseEntity.ok(vendorService.registerVendor(dto));
  }


}
