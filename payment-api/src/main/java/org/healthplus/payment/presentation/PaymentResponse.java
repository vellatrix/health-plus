package org.healthplus.payment.presentation;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PaymentResponse {

  private Long orderId;
  private boolean status;
  private String message;
  private String pg;
  private String method;
  private String content;
  private LocalDateTime paidAt;

}
