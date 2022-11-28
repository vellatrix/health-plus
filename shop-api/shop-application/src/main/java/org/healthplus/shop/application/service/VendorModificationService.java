package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.VendorNotFoundException;
import org.healthplus.shop.application.repository.VendorRepository;
import org.healthplus.shop.domain.vendor.Vendor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorModificationService {

  private final VendorRepository vendorRepository;

  public Vendor modifyVendor(Vendor vendorData) {

    Vendor vendor = vendorRepository.findById(vendorData.getId()).orElseThrow(VendorNotFoundException::new);
    vendor.changeVendorData(vendorData);

    return vendor;
  }
}

