package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductInfoInquiryDTO;
import org.healthplus.vendor.dto.ProductInfoListDTO;
import org.healthplus.vendor.dto.ProductOptionDetailInfoDTO;
import org.healthplus.vendor.dto.QProductInfoInquiryDTO;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.entity.QOptionGroup;
import org.healthplus.vendor.entity.QRestaurant;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.healthplus.vendor.entity.QMenu.*;
import static org.healthplus.vendor.entity.QOptionDetail.*;
import static org.healthplus.vendor.entity.QOptionGroup.*;
import static org.healthplus.vendor.entity.QRestaurant.*;


@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public long modifyProductInfo(Long vendorId, Long productId, ProductInfoListDTO productInfo) {
    return query.update(menu)
            .set(menu.name, productInfo.getName())
            .set(menu.price, productInfo.getPrice())
            .set(menu.calorie, productInfo.getCalorie())
            .set(menu.modifiedAt, LocalDateTime.now())
            .where(menu.menuId.eq(productId))
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
  public List<Menu> findProductListByVendorId(Long restaurantId) {
    return query.selectFrom(menu)
            .innerJoin(restaurant).on(restaurant.vendorId.eq(restaurantId))
            .fetch();

  }

  @Override
  public ProductInfoInquiryDTO findProductInfo(Long restaurantId, Long productId) {
    return query.select(new QProductInfoInquiryDTO(
              restaurant.businessName.as("businessName"),
              menu.name.as("productName"),
              menu.description,
              menu.calorie,
              menu.soldYn.as("soldYn"),
              menu.price.as("price")
            ))
            .from(restaurant)
            .innerJoin(menu).on(menu.restaurantId.eq(restaurant.restaurantId))
            .where(restaurant.restaurantId.eq(restaurantId).and(menu.menuId.eq(productId)))
            .fetchOne();
  }
}
