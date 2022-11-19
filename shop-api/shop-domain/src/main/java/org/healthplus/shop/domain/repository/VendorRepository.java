package org.healthplus.shop.domain.repository;

import org.healthplus.shop.domain.vendor.Vendor;

import java.util.Optional;

public interface VendorRepository {

  void save(Vendor vendor);

  Optional<Vendor> findById(Long id);
}
