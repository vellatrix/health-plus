package org.healthplus.payment.application;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TossPaymentRequest {

  private Integer amount;
  private String successUrl;
  private String failUrl;
  private String method;
  private String orderId;
  private String orderName;

}
