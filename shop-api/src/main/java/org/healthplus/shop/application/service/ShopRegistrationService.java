package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopRegistrationService {

  private final ShopRepository shopRepository;

  @Transactional
  public Shop registerShop(Shop shopData) {
    return shopRepository.save(shopData);
  }
}
