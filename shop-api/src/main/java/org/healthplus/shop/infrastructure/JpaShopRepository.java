package org.healthplus.shop.infrastructure;

import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Shop;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaShopRepository extends JpaRepository<Shop, Long> {

  @EntityGraph(
          attributePaths = {"menus", "menus.optionGroup", "menus.optionGroup.options"},
          type = EntityGraph.EntityGraphType.LOAD)
  Optional<Menu> findMenuById(Long id);

  Optional<Shop> findByVendorId(Long vendorId);

  List<Shop> findAllByVendorId(Long vendorId);

  List<Shop> findAllByCategoryId(Integer categoryId);

}
