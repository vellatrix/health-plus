package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

  Restaurant findByVendorId(Long vendorId);

}
