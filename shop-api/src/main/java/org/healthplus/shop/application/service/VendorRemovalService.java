package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.domain.exception.VendorNotFoundException;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.repository.ShopRepository;
import org.healthplus.shop.domain.repository.VendorRepository;
import org.healthplus.shop.domain.entity.Vendor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VendorRemovalService {

  private final VendorRepository vendorRepository;
  private final ShopRepository shopRepository;

  @Transactional
  public void removeVendor(Long vendorId) {
    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(VendorNotFoundException::new);

    Shop shop = shopRepository.findByVendorId(vendorId).orElseThrow(ShopNotFoundException::new);

    shopRepository.remove(shop);
    vendorRepository.remove(vendor);
  }
}
