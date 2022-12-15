package org.healthplus.order.domain;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.infrastructure.JpaShopRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidator {

  private final JpaShopRepository shopRepository;

  public void validate(Order order) {
    Shop shop = shopRepository.findById(order.getShopId()).orElseThrow(ShopNotFoundException::new);

    if(shop.getMinimumPrice() > order.calculateTotalPrice()) {
      throw new IllegalStateException(String.format("최소 주문 금액 %d원 이상 주문 가능합니다.", shop.getMinimumPrice()));
    }

  }

}
