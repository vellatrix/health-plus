package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopModificationService {

  private final ShopRepository shopRepository;

  @Transactional
  public Shop modifyShop(Long shopId, Shop shopData) {
    Shop shop = shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);
    shop.changeData(shopData);

    return shop;
  }
}
