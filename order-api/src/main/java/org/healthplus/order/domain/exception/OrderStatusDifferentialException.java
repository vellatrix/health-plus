package org.healthplus.order.domain.exception;

public class OrderStatusDifferentialException extends RuntimeException {

  public OrderStatusDifferentialException() {
    super("주문 상태가 올바르지 않습니다.");
  }
}
