package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.ShopNotFoundException;
import org.healthplus.shop.application.repository.ShopRepository;
import org.healthplus.shop.domain.shop.Shop;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShopRetrievalService {

  private ShopRepository shopRepository;

  public Shop retrieveShop(Long shopId) {
    return shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);
  }
}
