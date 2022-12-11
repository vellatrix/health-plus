package org.healthplus.order.domain.exception;

public class OrderCreationFailException extends RuntimeException{

  public OrderCreationFailException() {
    super("주문 생성을 실패하였습니다.");
  }
}
