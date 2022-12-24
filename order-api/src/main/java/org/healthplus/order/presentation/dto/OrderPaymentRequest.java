package org.healthplus.order.presentation.dto;

import lombok.Getter;

@Getter
public class OrderPaymentRequest {

  private Long orderId;
  private Integer amount;
}
