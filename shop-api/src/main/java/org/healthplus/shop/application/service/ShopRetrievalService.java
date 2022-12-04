package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.infrastructure.ShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopRetrievalService {

  private final ShopRepository shopRepository;

  @Transactional
  public Shop retrieveShop(Long shopId) {
    return shopRepository.findById(shopId).orElseThrow(ShopNotFoundException::new);
  }

  @Transactional
  public List<Shop> retrieveShops(Long vendorId) {
    return shopRepository.findAllByVendorId(vendorId);
  }

  public List<Shop> retrieveShopsWithCategory(Integer categoryId) {
    return shopRepository.findAllByCategoryId(categoryId);
  }
}
