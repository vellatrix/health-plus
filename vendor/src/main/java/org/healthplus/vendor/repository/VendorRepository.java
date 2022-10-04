package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.Vendor;
import org.healthplus.vendor.repository.impl.VendorRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VendorRepository extends JpaRepository<Vendor, Long>, VendorRepositoryCustom {
}
