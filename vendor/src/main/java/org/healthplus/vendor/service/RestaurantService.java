package org.healthplus.vendor.service;

import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;

public interface RestaurantService {

  RestaurantInfoInquiryDTO getRestaurant(Long restaurantId);
}
