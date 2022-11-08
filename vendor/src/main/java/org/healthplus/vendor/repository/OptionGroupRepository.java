package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.OptionGroup;
import org.healthplus.vendor.repository.impl.OptionGroupRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionGroupRepository extends JpaRepository<OptionGroup, Long>, OptionGroupRepositoryCustom {

  long deleteByMenuId(Long menuId);

  List<OptionGroup> findAllByMenuId(Long menuId);

}
