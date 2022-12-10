package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Menu;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.exception.MenuNotFoundException;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MenuRemovalService {

  private final ShopRepository shopRepository;

  @Transactional
  public void removeMenu(Long shopId, Long menuId) {
    Shop shop = shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);
    shop.deleteMenu(menuId);
  }
}
