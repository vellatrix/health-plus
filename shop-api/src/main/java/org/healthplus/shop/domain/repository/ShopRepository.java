package org.healthplus.shop.domain.repository;

import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopRepository {

  Shop save(Shop shop);

  Optional<Shop> findById(Long id);

  Optional<Shop> findByVendorId(Long vendorId);

  void remove(Shop shop);

  List<Shop> findAllByVendorId(Long vendorId);

  List<Shop> findAllByCategoryId(Integer categoryId);

  Optional<Menu> findMenuByMenuId(Long menuId);

  List<Menu> findMenus(Long shopId, int start, int size);

  List<Menu> findAllMenus(Long shopId);
}
