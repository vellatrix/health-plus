package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.Restaurant;
import org.healthplus.vendor.repository.impl.RestaurantRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, RestaurantRepositoryCustom {

  Restaurant findByVendorId(Long vendorId);

}
