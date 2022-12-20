package org.healthplus.order.domain.exception;

public class OrderPriceNotMatchedException extends RuntimeException {

  public OrderPriceNotMatchedException() {
    super("주문 금액과 결제 금액이 일치하지 않습니다.");
  }
}
