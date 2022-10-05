package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.entity.QMenu;
import org.healthplus.vendor.entity.QOptionDetail;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.healthplus.vendor.entity.QMenu.*;
import static org.healthplus.vendor.entity.QOptionDetail.*;


@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public long modifyProductInfo(Long vendorId, Long productId, ProductInfoDTO productInfo) {
    return query.update(menu)
            .set(menu.name, productInfo.getName())
            .set(menu.price, productInfo.getPrice())
            .set(menu.calorie, productInfo.getCalorie())
            .set(menu.modifiedAt, LocalDateTime.now())
            .where(menu.menuId.eq(productId))
            .execute();
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

  @Override
  public List<Long> findIdList(Long restaurantId) {
    return query.select(menu.menuId)
            .from(menu)
            .where(menu.restaurantId.eq(restaurantId))
            .fetch();
  }
}
