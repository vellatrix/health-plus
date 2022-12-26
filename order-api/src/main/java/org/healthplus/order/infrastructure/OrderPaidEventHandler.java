package org.healthplus.order.infrastructure;

import lombok.RequiredArgsConstructor;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.event.OrderNotifiedEvent;
import org.healthplus.order.domain.event.OrderPaidEvent;
import org.healthplus.order.domain.repository.OrderRepository;
import org.healthplus.payment.application.PaymentService;
import org.healthplus.payment.presentation.PaymentRequest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderPaidEventHandler {

  private final OrderRepository orderRepository;
  private final PaymentService paymentService;
  private final ApplicationEventPublisher publisher;

  @EventListener(OrderPaidEvent.class)
  public void handle(OrderPaidEvent event) {
    int itemCount = event.getOrderLines().size() - 1;
    String itemName = event.getOrderLines().get(0).getName();

    boolean isPaymentSuccessful = paymentService.payOrder(new PaymentRequest(
                                                      event.getOrderId(),
                                                      event.getTotalPrice(),
                                                      String.format("%s 외 %d개", itemName, itemCount)));

    if(isPaymentSuccessful) {
      publisher.publishEvent(OrderNotifiedEvent.toEvent(event));
    }
    else {
      orderRepository.remove(Order.findOrderId(event.getOrderId()));
    }
  }
}
