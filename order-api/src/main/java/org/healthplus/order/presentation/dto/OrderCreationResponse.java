package org.healthplus.order.presentation.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderCreationResponse {

  private Long orderId;
  private Long customerId;
  private Long shopId;
  private Integer amount;
  private Integer deliveryFee;
  private List<String> menuName;
}
