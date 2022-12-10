package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.domain.exception.VendorNotFoundException;
import org.healthplus.shop.infrastructure.VendorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VendorModificationService {

  private final VendorRepository vendorRepository;

  @Transactional
  public Vendor modifyVendor(Long vendorId, Vendor vendorData) {
    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(VendorNotFoundException::new);
    vendor.changeData(vendorData);

    return vendorData;
  }
}

