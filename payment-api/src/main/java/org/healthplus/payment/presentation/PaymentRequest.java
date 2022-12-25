package org.healthplus.payment.presentation;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PaymentRequest {

  private Long orderId;
  private Integer amount;
  private String itemName;

  public PaymentRequest(Long orderId, Integer amount, String itemName) {
    this.orderId = orderId;
    this.amount = amount;
    this.itemName = itemName;
  }
}
