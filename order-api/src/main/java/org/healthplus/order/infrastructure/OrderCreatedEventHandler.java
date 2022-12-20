package org.healthplus.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.repository.OrderRepository;
import org.healthplus.payment.application.PaymentService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderCreatedEventHandler {

  private final OrderRepository orderRepository;
  private final PaymentService paymentService;
  private final ApplicationEventPublisher publisher;





}
