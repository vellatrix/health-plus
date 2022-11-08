package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoByCategoryDTO;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.QProductInfoByCategoryDTO;
import org.healthplus.vendor.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.healthplus.vendor.entity.QMenu.menu;


@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public long modifyProductInfo(Long restaurantId, Long productId, ProductInfoDTO productInfo) {
    return query.update(menu)
            .set(menu.name, productInfo.getName())
            .set(menu.price, productInfo.getPrice())
            .set(menu.calorie, productInfo.getCalorie())
            .set(menu.modifiedAt, LocalDateTime.now())
            .where(menu.menuId.eq(productId).and(menu.restaurantId.eq(restaurantId)))
            .execute();
  }

  @Override
  public List<Long> findIdList(Long restaurantId) {
    return query.select(menu.menuId)
            .from(menu)
            .where(menu.restaurantId.eq(restaurantId))
            .fetch();
  }

  @Override
  public Page<ProductInfoByCategoryDTO> findByCategoryId(Long categoryId, Pageable pageable) {
    List<ProductInfoByCategoryDTO> content = query.select(new QProductInfoByCategoryDTO(
              menu.menuId.as("menuId"),
              menu.categoryId.as("categoryId"),
              menu.name,
              menu.price,
              menu.stock,
              menu.description
            ))
            .from(menu)
            .where(menu.categoryId.eq(categoryId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

    return new PageImpl<>(content, pageable, content.size());
  }

}
