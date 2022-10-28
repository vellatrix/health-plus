package org.healthplus.vendor.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.healthplus.vendor.dto.QRestaurantInfoInquiryDTO;
import org.healthplus.vendor.dto.RestaurantInfoInquiryDTO;

import static org.healthplus.vendor.entity.QRestaurant.restaurant;

@RequiredArgsConstructor
public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

  private final JPAQueryFactory query;

  @Override
  public RestaurantInfoInquiryDTO findRestaurantInfo(Long restaurantId) {
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
            .where(restaurant.restaurantId.eq(restaurantId))
            .fetchOne();

  }
}
