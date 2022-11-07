package org.healthplus.user.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

  EXIST_USER(HttpStatus.FORBIDDEN, "이미 존재하는 회원입니다.");

  private final HttpStatus status;
  private final String message;
}
