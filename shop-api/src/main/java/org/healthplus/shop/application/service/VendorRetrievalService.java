package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.exception.VendorNotFoundException;
import org.healthplus.shop.infrastructure.VendorRepository;
import org.healthplus.shop.domain.entity.Vendor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorRetrievalService {

  private final VendorRepository vendorRepository;

  public Vendor retrieveVendor(Long vendorId) {
    return vendorRepository.findById(vendorId).orElseThrow(VendorNotFoundException::new);
  }

}
