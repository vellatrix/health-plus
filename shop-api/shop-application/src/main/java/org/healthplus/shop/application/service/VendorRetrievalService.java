package org.healthplus.shop.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.exception.VendorNotFoundException;
import org.healthplus.shop.application.repository.VendorRepository;
import org.healthplus.shop.domain.vendor.Vendor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VendorRetrievalService {

  private final VendorRepository vendorRepository;

  public Vendor retrieveVendor(Long vendorId) {
    return Optional.ofNullable(vendorRepository.findBasicInfo(vendorId)).orElseThrow(VendorNotFoundException::new);
  }

}
