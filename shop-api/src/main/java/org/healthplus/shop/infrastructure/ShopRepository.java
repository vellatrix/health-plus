package org.healthplus.shop.infrastructure;

import org.healthplus.shop.entity.Menu;
import org.healthplus.shop.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {

  void save(Shop shop);

  Optional<Shop> findById(Long id);

  void saveMenu(Menu menu);

  void saveMenus(List<Menu> menus);

  List<Menu> findByShopId(Long shopId);

}
