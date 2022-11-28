package org.healthplus.shop.application.exception;

public class ShopNotFoundException extends RuntimeException{

  public ShopNotFoundException() {
    super("존재하지 않는 가게입니다.");
  }
}
