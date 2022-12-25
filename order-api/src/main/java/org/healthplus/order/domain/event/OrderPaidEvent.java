package org.healthplus.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.healthplus.model.domain.DomainEvent;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.entity.OrderStatus;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class OrderPaidEvent extends DomainEvent {

  private Long orderId;
  private Long shopId;
  private Long customerId;
  private OrderStatus orderStatus;
  private Integer totalPrice;
  private List<OrderLine> orderLines;

  public static OrderPaidEvent toEvent(Order order) {
    return OrderPaidEvent.builder()
            .orderId(order.getId())
            .customerId(order.getCustomerId())
            .shopId(order.getShopId())
            .orderStatus(order.getOrderStatus())
            .orderLines(order.getOrderLines().stream()
                    .map(orderLine -> new OrderLine(orderLine.getName(), orderLine.getPrice(), orderLine.getQuantity()))
                    .collect(Collectors.toList()))
            .build();
  }

  @AllArgsConstructor
  @Getter
  public static class OrderLine {
    private String name;
    private Integer price;
    private Integer quantity;
  }

}
