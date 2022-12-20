package org.healthplus.order.domain.exception;

public class OrderNotFoundException extends RuntimeException {

  public OrderNotFoundException() {
    super("존재하지 않는 주문입니다.");
  }
}
