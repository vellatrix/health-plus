package org.healthplus.shop.domain.exception;

public class ShopNotFoundException extends RuntimeException {

  public ShopNotFoundException() {
    super("존재하지 않는 가게입니다.");
  }
}
