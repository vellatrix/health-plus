package org.healthplus.order.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.exception.OrderNotFoundException;
import org.healthplus.order.domain.exception.OrderPriceNotMatchedException;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderPaymentService {

  private final OrderRepository orderRepository;
  private final ApplicationEventPublisher publisher;

  public Order pay(Order orderData) {
    Order order = orderRepository.findById(orderData.getId()).orElseThrow(OrderNotFoundException::new);
    try {
      order.payOrder(orderData.getTotalPrice());
    }
    catch (OrderPriceNotMatchedException e) {
      order.cancelOrder();
    }

    order.occurredEvents().forEach(publisher::publishEvent);
    return order;
  }
}
