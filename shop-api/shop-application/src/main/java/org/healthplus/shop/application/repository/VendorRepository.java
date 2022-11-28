package org.healthplus.shop.application.repository;

import org.healthplus.shop.domain.vendor.Vendor;

import java.util.Optional;

public interface VendorRepository {

  Vendor save(Vendor vendor);

  Optional<Vendor> findById(Long id);

  Vendor findBasicInfo(Long id);

  void remove(Vendor vendor);
}
