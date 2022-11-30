package org.healthplus.shop.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.shop.application.repository.VendorRepository;
import org.healthplus.shop.domain.vendor.Vendor;
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
  public Vendor findBasicInfo(Long vendorId) {
    return em.createQuery(
            "select v.id, v.name, v.businessName, v.businessNumber, v.businessHour, v.mainType, v.subType " +
            "from Vendor v where v.id = :vendorId", Vendor.class)
            .setParameter("vendorId", vendorId)
            .getSingleResult();
  }

  @Override
  public void remove(Vendor vendor) {
    jpaVendorRepository.delete(vendor);
  }


}
