package org.healthplus.order.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.event.OrderPayedEvent;
import org.healthplus.order.domain.exception.OrderNotFoundException;
import org.healthplus.order.domain.exception.OrderPriceNotMatchedException;
import org.healthplus.order.domain.repository.OrderRepository;

@RequiredArgsConstructor
public class OrderPaymentService {

  private final OrderRepository orderRepository;

  public Order pay(OrderPayedEvent event) {
    Order order = orderRepository.findById(event.getOrderId()).orElseThrow(OrderNotFoundException::new);
    try {
      order.payOrder(event.getAmount());
    }
    catch (OrderPriceNotMatchedException e) {
      order.cancelOrder();
    }

    return order;
  }
}
