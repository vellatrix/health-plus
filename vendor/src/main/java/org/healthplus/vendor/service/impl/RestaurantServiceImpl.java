package org.healthplus.vendor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;
import org.healthplus.vendor.repository.RestaurantRepository;
import org.healthplus.vendor.repository.VendorRepository;
import org.healthplus.vendor.service.RestaurantService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final VendorRepository vendorRepository;

  @Override
  public RestaurantInfoInquiryDTO getRestaurant(Long vendorId) {
    return vendorRepository.findRestaurantInfo(vendorId);
  }
}
