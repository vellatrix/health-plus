package org.healthplus.shop.domain.repository;

import org.healthplus.shop.domain.shop.Menu;
import org.healthplus.shop.domain.shop.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {

  void save(Shop shop);

  Optional<Shop> findById(Long id);

  void saveMenu(Menu menu);

  void saveMenus(List<Menu> menus);

  List<Menu> findByShopId(Long shopId);

}
