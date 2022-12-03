package org.healthplus.shop.infrastructure;

import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Shop;
import java.util.List;
import java.util.Optional;

public interface ShopRepository {

  void save(Shop shop);

  Optional<Shop> findById(Long id);

  void saveMenu(Menu menu);

  void saveMenus(List<Menu> menus);

  List<Menu> findByShopId(Long shopId);

  Optional<Shop> findByVendorId(Long vendorId);

  void remove(Shop shop);
}
