package org.healthplus.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.application.service.OrderCancellationService;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.event.OrderCanceledEvent;
import org.healthplus.order.domain.exception.AlreadyCanceledOrderException;
import org.healthplus.order.domain.exception.OrderNotFoundException;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCanceledEventHandler {

  private final OrderCancellationService orderCancellationService;

  @EventListener(OrderCanceledEvent.class)
  public void handle(OrderCanceledEvent event) {
    orderCancellationService.cancelOrder(event.getOrderId());
  }
}
