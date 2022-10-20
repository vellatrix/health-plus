package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.QProductOptionDetailInfoDTO;
import org.healthplus.vendor.entity.OptionDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.healthplus.vendor.entity.QMenu.menu;
import static org.healthplus.vendor.entity.QOptionDetail.optionDetail;
import static org.healthplus.vendor.entity.QOptionGroup.optionGroup;


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

  @Override
  public List<OptionDetail> findDetailList(List<Long> optionGroupIdList) {
    return query.selectFrom(optionDetail)
            .where(optionDetail.optionGroupId.in(optionGroupIdList))
            .fetch();
  }

  @Override
  public List<ProductOptionDetailInfoDTO> findProductOptionInfo(Long productId) {
    return query.select(new QProductOptionDetailInfoDTO(
            optionDetail.optionDetailId,
            optionDetail.name,
            optionDetail.price
            ))
            .from(menu)
            .innerJoin(optionGroup).on(optionGroup.menuId.eq(menu.menuId))
            .innerJoin(optionDetail).on(optionDetail.optionGroupId.eq(optionGroup.optionGroupId))
            .where(menu.menuId.eq(productId))
            .fetch();

  }

  @Override
  public long modifyOptionDetailInfo(List<ProductOptionDetailInfoDTO> optionInfo) {

    long count = 0;

    for (ProductOptionDetailInfoDTO option : optionInfo) {
      long updateResult = query.update(optionDetail)
              .set(optionDetail.name, option.getName())
              .set(optionDetail.price, option.getPrice())
              .where(optionDetail.optionDetailId.eq(option.getOptionDetailId()))
              .execute();
      if(updateResult == 1) count++;
    }

    return count;
  }
}
