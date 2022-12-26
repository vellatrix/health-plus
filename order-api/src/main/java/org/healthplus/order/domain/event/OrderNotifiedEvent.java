package org.healthplus.order.domain.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderNotifiedEvent {

  private Long orderId;
  private Long shopId;
  private Integer totalPrice;
  private String address;
  private List<OrderNotifiedEvent.OrderLine> orderLines;

  @Builder
  public OrderNotifiedEvent(Long orderId,
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
