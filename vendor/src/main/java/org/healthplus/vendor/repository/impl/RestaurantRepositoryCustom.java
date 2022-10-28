package org.healthplus.vendor.repository.impl;

import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;

public interface RestaurantRepositoryCustom {

  RestaurantInfoInquiryDTO findRestaurantInfo(Long restaurantId);
}
