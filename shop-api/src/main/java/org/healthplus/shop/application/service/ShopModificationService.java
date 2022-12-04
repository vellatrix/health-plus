package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.ShopNotFoundException;
import org.healthplus.shop.domain.ShopDomain;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopModificationService {

  private final ShopRepository shopRepository;

  @Transactional
  public Shop modifyShop(Long shopId, ShopDomain shopDomain) {
    Shop shop = shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);
    shopDomain.changeShopData(shop);

    return shop;
  }
}
