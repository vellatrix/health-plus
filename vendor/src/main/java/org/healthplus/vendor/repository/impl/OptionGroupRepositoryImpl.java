package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.entity.OptionGroup;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.healthplus.vendor.entity.QOptionGroup.*;


@Repository
@RequiredArgsConstructor
public class OptionGroupRepositoryImpl implements OptionGroupRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public List<Long> findIdList(List<Long> menuIdList) {
    return query.select(optionGroup.optionGroupId)
            .from(optionGroup)
            .where(optionGroup.menuId.in(menuIdList))
            .fetch();

  }

  @Override
  public List<OptionGroup> findGroupList(List<Long> menuId) {
    return query.selectFrom(optionGroup)
            .where(optionGroup.menuId.in(menuId))
            .fetch();
  }

  @Override
  public long modifyOptionGroupInfo(ProductOptionGroupInfoDTO optionGroupDto) {
      return query.update(optionGroup)
              .set(optionGroup.name, optionGroupDto.getName())
              .set(optionGroup.basicChoiceYn, optionGroupDto.getBasicChoiceYn())
              .set(optionGroup.etcChoiceYn, optionGroupDto.getEtcChoiceYn())
              .where(optionGroup.optionGroupId.eq(optionGroupDto.getOptionGroupId()))
              .execute();
  }
}
