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
public class OrderCreationEvent extends DomainEvent {

  private Long orderId;
  private Long shopId;
  private Long customerId;
  private OrderStatus orderStatus;
  private Integer totalPrice;
  private List<OrderLine> orderLines;

  @Builder
  public OrderCreationEvent(Long orderId,
                            Long shopId,
                            Long customerId,
                            OrderStatus orderStatus,
                            Integer totalPrice,
                            List<OrderLine> orderLines) {
    this.orderId = orderId;
    this.shopId = shopId;
    this.customerId = customerId;
    this.orderStatus = orderStatus;
    this.totalPrice = totalPrice;
    this.orderLines = orderLines;
  }

  public static OrderCreationEvent toEvent(Order order) {
    return OrderCreationEvent.builder()
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
