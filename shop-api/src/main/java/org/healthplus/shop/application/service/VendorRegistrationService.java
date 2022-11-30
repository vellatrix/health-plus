package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.repository.VendorRepository;
import org.healthplus.shop.domain.vendor.Vendor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorRegistrationService {

  private final VendorRepository vendorRepository;

  public Vendor registerVendor(Vendor vendor) {
    return vendorRepository.save(vendor);
  }
}
