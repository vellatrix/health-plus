package org.healthplus.shop.infrastructure;

import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Shop;
import java.util.List;
import java.util.Optional;

public interface ShopRepository {

  Shop save(Shop shop);

  Optional<Shop> findById(Long id);

  Menu saveMenu(Menu menu);

  void saveMenus(List<Menu> menus);

  List<Menu> findByShopId(Long shopId);

  Optional<Shop> findByVendorId(Long vendorId);

  void remove(Shop shop);

  List<Shop> findAllByVendorId(Long vendorId);

  List<Shop> findAllByCategoryId(Integer categoryId);

  Optional<Menu> findMenuByMenuId(Long menuId);
}
