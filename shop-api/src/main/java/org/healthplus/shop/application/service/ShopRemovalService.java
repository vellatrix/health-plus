package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.ShopNotFoundException;
import org.healthplus.shop.application.exception.VendorNotFoundException;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.healthplus.shop.infrastructure.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
