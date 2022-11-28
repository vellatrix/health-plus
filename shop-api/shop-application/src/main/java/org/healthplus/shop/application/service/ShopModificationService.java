package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.ShopNotFoundException;
import org.healthplus.shop.application.repository.ShopRepository;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopModificationService {

  private ShopRepository shopRepository;

  public Shop modifyShop(Shop shopData) {

    Shop shop = shopRepository.findById(shopData.getId()).orElseThrow(ShopNotFoundException::new);
    shop.changeShopData(shop);

    return shop;
  }
}
