package org.healthplus.vendor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;

  public RestaurantInfoInquiryDTO getRestaurant(Long restaurantId) {
    return restaurantRepository.findRestaurantInfo(restaurantId);
  }
}
