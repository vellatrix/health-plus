package org.healthplus.vendor.repository;

import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.repository.impl.OptionDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionDetailRepository extends JpaRepository<OptionDetail, Long>, OptionDetailRepositoryCustom {

  @Modifying
  @Query(value = "Delete from option_detail where option_group_id IN (:optionGroupIdList)", nativeQuery = true)
  int deleteByOptionGroupIdList(@Param("optionGroupIdList") List<Long> optionGroupIdList);


  long deleteByOptionGroupId(Long optionGroupId);

  List<OptionDetail> findAllByOptionGroupIdIn(List<Long> optionGroupIdList);
}
