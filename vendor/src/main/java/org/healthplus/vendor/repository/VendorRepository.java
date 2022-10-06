package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.repository.impl.VendorRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long>, VendorRepositoryCustom {
}
