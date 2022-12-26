package org.healthplus.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.event.OrderNotifiedEvent;
import org.healthplus.shop.domain.entity.Shop;
import org.healthplus.shop.domain.exception.ShopNotFoundException;
import org.healthplus.shop.domain.repository.ShopRepository;
import org.healthplus.shop.domain.repository.VendorRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderNotifiedEventHandler {

  private final ShopRepository shopRepository;
//  private final Notifier notifier;

  @EventListener(OrderNotifiedEvent.class)
  public void handle(OrderNotifiedEvent event) {
    Shop shop = shopRepository.findById(event.getShopId()).orElseThrow(ShopNotFoundException::new);

  }
}
