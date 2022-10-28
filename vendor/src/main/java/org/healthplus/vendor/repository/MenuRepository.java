package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.repository.impl.MenuRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long>, MenuRepositoryCustom {

  List<Menu> findAllByRestaurantId(Long restaurantId);
}
