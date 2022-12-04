package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.exception.VendorNotFoundException;
import org.healthplus.shop.domain.VendorDomain;
import org.healthplus.shop.infrastructure.VendorRepository;
import org.healthplus.shop.domain.entity.Vendor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VendorModificationService {

  private final VendorRepository vendorRepository;

  @Transactional
  public VendorDomain modifyVendor(Long vendorId, VendorDomain vendorData) {

    Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(VendorNotFoundException::new);
    vendorData.changeVendorData(vendor);

    return vendorData;
  }
}

