package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.repository.impl.OptionDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionDetailRepository extends JpaRepository<OptionDetail, Long>, OptionDetailRepositoryCustom {

}
