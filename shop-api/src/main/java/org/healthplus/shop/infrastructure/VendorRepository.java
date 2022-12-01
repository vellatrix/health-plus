package org.healthplus.shop.infrastructure;

import org.healthplus.shop.entity.Vendor;

import java.util.Optional;

public interface VendorRepository {

  Vendor save(Vendor vendor);

  Optional<Vendor> findById(Long id);

  Vendor findBasicInfo(Long id);

  void remove(Vendor vendor);
}
