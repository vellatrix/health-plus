package org.healthplus.order.domain.exception;

public class InvalidOrderStatusException extends RuntimeException {

  public InvalidOrderStatusException() {
    super("주문 상태일 때만 결제 가능합니다.");
  }
}
