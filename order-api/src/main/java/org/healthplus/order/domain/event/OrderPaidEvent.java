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
public class OrderPaidEvent extends DomainEvent {

  private Long orderId;
  private Long shopId;
  private Long customerId;
  private OrderStatus orderStatus;
  private Integer totalPrice;
  private String customerAddress;
  private List<OrderLine> orderLines;

  @Builder
  private OrderPaidEvent(Long orderId,
                         Long shopId,
                         Long customerId,
                         OrderStatus orderStatus,
                         Integer totalPrice,
                         String customerAddress,
                         List<OrderLine> orderLines) {
    this.orderId = orderId;
    this.shopId = shopId;
    this.customerId = customerId;
    this.orderStatus = orderStatus;
    this.totalPrice = totalPrice;
    this.customerAddress = customerAddress;
    this.orderLines = orderLines;
  }

  public static OrderPaidEvent toEvent(Order order) {
    String address = new StringBuilder(order.getAddress().getCity())
            .append(" ")
            .append(order.getAddress().getStreet())
            .toString();

    return OrderPaidEvent.builder()
            .orderId(order.getId())
            .customerId(order.getCustomerId())
            .shopId(order.getShopId())
            .orderStatus(order.getOrderStatus())
            .customerAddress(address)
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
