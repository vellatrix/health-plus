package org.healthplus.order.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.domain.EventPublisher;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.event.OrderCreationEvent;
import org.healthplus.order.domain.exception.OrderCreationFailException;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreationService {

  private final OrderRepository orderRepository;
  private final EventPublisher eventPublisher;

  public void createOrder(Order orderData) {
    Order order = orderRepository.save(orderData);

    if(order == null) throw new OrderCreationFailException();

    order.changeStatus();

    eventPublisher.publish(OrderCreationEvent.toEvent(order));
  }
}
