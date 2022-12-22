package org.healthplus.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

  private final JpaOrderRepository jpaOrderRepository;


  @Override
  public Order save(Order order) {
    return jpaOrderRepository.save(order);
  }

  @Override
  public Optional<Order> findById(Long orderId) {
    return jpaOrderRepository.findById(orderId);
  }

  @Override
  public void remove(Order order) {
    jpaOrderRepository.delete(order);
  }
}
