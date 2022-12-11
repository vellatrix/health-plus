package org.healthplus.order.domain.repository;

import org.healthplus.order.domain.entity.Order;

public interface OrderRepository {

  Order save(Order order);
}
