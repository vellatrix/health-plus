package org.healthplus.order.application.service;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.repository.OrderRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderRegistrationService {

  private final OrderRepository orderRepository;
  private final ApplicationEventPublisher publisher;

  @Transactional
  public void registerOrder() {

  }
}
