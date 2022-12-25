package org.healthplus.order.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.OrderValidator;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderCreationService {

  private final OrderRepository orderRepository;
  private final OrderValidator orderValidator;

  @Transactional
  public Order createOrder(Order orderData) {

    orderValidator.validate(orderData);

    Order order = orderRepository.save(orderData);

    order.makeOrder();

    return order;
  }
}
