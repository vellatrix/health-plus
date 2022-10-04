package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.repository.impl.MenuRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>, MenuRepositoryCustom {

  void deleteByRestaurantId(Long restaurantId);


}
