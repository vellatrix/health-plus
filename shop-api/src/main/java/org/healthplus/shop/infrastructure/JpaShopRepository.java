package org.healthplus.shop.infrastructure;

import org.healthplus.shop.entity.Menu;
import org.healthplus.shop.entity.Shop;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaShopRepository extends JpaRepository<Shop, Long> {

  @EntityGraph(
          attributePaths = {"menus", "menus.optionGroup", "menus.optionGroup.options"},
          type = EntityGraph.EntityGraphType.LOAD)
  Optional<Menu> findMenuById(Long id);
}
