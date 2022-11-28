package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.repository.ShopRepository;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopRegistrationService {

  private ShopRepository shopRepository;

  public Shop registerShop(Shop shop) {

    return shopRepository.saveShop(shop);
  }
}
