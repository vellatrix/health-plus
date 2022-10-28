package org.healthplus.vendor.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

  private final RestaurantService restaurantService;

  @GetMapping("/{restaurantId}/info")
  public RestaurantInfoInquiryDTO getRestaurantInfo(@PathVariable Long restaurantId) {

    return restaurantService.getRestaurant(restaurantId);
  }
}
