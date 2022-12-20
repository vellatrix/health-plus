package org.healthplus.order.domain.exception;

public class AlreadyCanceledOrderException extends RuntimeException {

  public AlreadyCanceledOrderException() {
    super("이미 취소된 주문입니다.");
  }
}
