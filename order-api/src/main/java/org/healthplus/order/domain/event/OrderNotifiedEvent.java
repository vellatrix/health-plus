package org.healthplus.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderNotifiedEvent {

  private Long orderId;
  private Long shopId;
  private Integer totalPrice;
  private String address;
  private List<OrderNotifiedEvent.OrderLine> orderLines;

  public static OrderNotifiedEvent toEvent(OrderPaidEvent paidEvent) {
    return OrderNotifiedEvent.builder()
            .orderId(paidEvent.getOrderId())
            .shopId(paidEvent.getShopId())
            .totalPrice(paidEvent.getTotalPrice())
            .address(paidEvent.getCustomerAddress())
            .orderLines(paidEvent.getOrderLines().stream()
                    .map(ol -> new OrderNotifiedEvent.OrderLine(
                            ol.getName(),
                            ol.getPrice(),
                            ol.getQuantity()))
                    .collect(Collectors.toList()))
            .build();
  }

  @Builder
  private OrderNotifiedEvent(Long orderId,
                            Long shopId,
                            Integer totalPrice,
                            String address,
                            List<OrderNotifiedEvent.OrderLine> orderLines) {
    this.orderId = orderId;
    this.shopId = shopId;
    this.totalPrice = totalPrice;
    this.address = address;
    this.orderLines = orderLines;
  }

  @AllArgsConstructor
  @Getter
  public static class OrderLine {
    private String name;
    private Integer price;
    private Integer quantity;
  }
}
