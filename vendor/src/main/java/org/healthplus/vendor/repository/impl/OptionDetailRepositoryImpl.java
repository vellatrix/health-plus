package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.entity.QOptionDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.healthplus.vendor.entity.QOptionDetail.*;

@Repository
@RequiredArgsConstructor
public class OptionDetailRepositoryImpl implements OptionDetailRepositoryCustom {

  private final JPAQueryFactory query;


  @Override
  public List<Long> findIdList(List<Long> optionGroupIdList) {
    return query.select(optionDetail.optionDetailId)
            .from(optionDetail)
            .where(optionDetail.optionGroupId.in(optionGroupIdList))
            .fetch();
  }
}
