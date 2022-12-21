package org.healthplus.order.domain.repository;

import org.healthplus.order.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository {

  Order save(Order order);

  Optional<Order> findById(Long orderId);

  void remove(Order order);
}
