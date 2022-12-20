package org.healthplus.shop.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.domain.entity.Vendor;
import org.healthplus.shop.domain.repository.VendorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VendorRepositoryAdapter implements VendorRepository {

  private final JpaVendorRepository jpaVendorRepository;
  private final EntityManager em;

  @Override
  public Vendor save(Vendor vendor) {
    return jpaVendorRepository.save(vendor);
  }

  @Override
  public Optional<Vendor> findById(Long id) {
    return jpaVendorRepository.findById(id);
  }


  @Override
  public void remove(Vendor vendor) {
    jpaVendorRepository.delete(vendor);
  }


}
