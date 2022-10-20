package org.healthplus.deliveryworker.exception;

import static org.springframework.http.HttpStatus.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {


  INVALID_DELIVERY_WORKER(NOT_FOUND, "존재하지 않는 배달 노동자입니다."),
  DELIVERY_REMOVAL_FAIL(NOT_IMPLEMENTED, "판매회원 탈퇴가 실패되었습니다.");

  private final HttpStatus httpStatus;
  private final String message;

}
