package org.healthplus.order.infrastructure;

import org.healthplus.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<Order, Long> {
}
