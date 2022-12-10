package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.repository.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ShopRemovalService {

  private final ShopRepository shopRepository;

  @Transactional
  public void removeShop(Long vendorId, Long shopId) {
    Shop shop = shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);

    shopRepository.remove(shop);
  }
}
