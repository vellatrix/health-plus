package org.healthplus.shop.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.repository.VendorRepository;
import org.healthplus.shop.domain.vendor.Vendor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VendorRepositoryAdapter implements VendorRepository {

  private final JpaVendorRepository jpaVendorRepository;

  @Override
  public void save(Vendor vendor) {
    jpaVendorRepository.save(vendor);
  }

  @Override
  public Optional<Vendor> findById(Long id) {
    return jpaVendorRepository.findById(id);
  }
}
