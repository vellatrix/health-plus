package org.healthplus.order.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.exception.AlreadyCanceledOrderException;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderCancellationService {

  private final OrderRepository orderRepository;

  @Transactional
  public void cancelOrder(Long orderId) {
    Order order = orderRepository.findById(orderId).orElseThrow(AlreadyCanceledOrderException::new);
    orderRepository.remove(order);
  }
}
