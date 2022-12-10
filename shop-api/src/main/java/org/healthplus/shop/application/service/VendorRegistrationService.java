package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.infrastructure.VendorRepository;
import org.healthplus.shop.domain.entity.Vendor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorRegistrationService {

  private final VendorRepository vendorRepository;

  public Vendor registerVendor(Vendor vendorData) {
    return vendorRepository.save(vendorData);
  }
}
