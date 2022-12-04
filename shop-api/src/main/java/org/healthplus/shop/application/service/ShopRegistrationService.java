package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.ShopDomain;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopRegistrationService {

  private final ShopRepository shopRepository;

  @Transactional
  public Shop registerShop(ShopDomain shopDomain) {
    Shop shop = shopDomain.addShop();
    return shopRepository.save(shop);
  }
}
