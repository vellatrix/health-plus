package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.VendorNotFoundException;
import org.healthplus.shop.infrastructure.VendorRepository;
import org.healthplus.shop.entity.Vendor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorRemovalService {

  private final VendorRepository vendorRepository;

  public void removeVendor(Long vendorId) {
    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(VendorNotFoundException::new);

    vendorRepository.remove(vendor);
  }
}
