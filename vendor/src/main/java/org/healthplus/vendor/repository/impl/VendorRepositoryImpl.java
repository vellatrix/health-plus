package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.*;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.healthplus.vendor.entity.QMenu.*;
import static org.healthplus.vendor.entity.QOptionDetail.*;
import static org.healthplus.vendor.entity.QOptionGroup.*;
import static org.healthplus.vendor.entity.QRestaurant.*;


@Repository
@RequiredArgsConstructor
public class VendorRepositoryImpl implements VendorRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public ProductInfoInquiryDTO findProductInfo(Long vendorId, Long productId) {
    return query.select(new QProductInfoInquiryDTO(
              restaurant.businessName.as("businessName"),
              menu.name.as("productName"),
              menu.description,
              menu.calorie,
              menu.soldYn.as("soldYn"),
              menu.price.as("price")
            ))
            .from(restaurant)
            .where(restaurant.vendorId.eq(vendorId).and(menu.menuId.eq(productId)))
            .innerJoin(menu).on(menu.restaurantId.eq(restaurant.restaurantId))
            .fetchOne();
  }

  @Override
  public List<ProductOptionDetailInfoDTO> findProductOptionInfo(Long productId) {
    return query.select(new QProductOptionDetailInfoDTO(
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
  public RestaurantInfoInquiryDTO findRestaurantInfo(Long vendorId) {
    return query.select(new QRestaurantInfoInquiryDTO(
              restaurant.businessName.as("businessName"),
              restaurant.businessHour.as("businessHour"),
              restaurant.businessNumber.as("businessNumber"),
              restaurant.minimumPrice.as("minimumPrice"),
              restaurant.deliveryFee.as("deliveryFee"),
              restaurant.openYn.as("openYn"),
              restaurant.city.as("city"),
              restaurant.street.as("street"),
              restaurant.zipCode.as("zipCode")
            ))
            .from(restaurant)
            .where(restaurant.vendorId.eq(vendorId))
            .fetchOne();

  }

}
