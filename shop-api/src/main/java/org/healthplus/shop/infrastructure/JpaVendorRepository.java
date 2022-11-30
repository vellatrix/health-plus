package org.healthplus.shop.infrastructure;

import org.healthplus.shop.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVendorRepository extends JpaRepository<Vendor, Long> {
}
