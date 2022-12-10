package org.healthplus.account.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class JwtException extends RuntimeException {

  private final ErrorCode errorCode;
}
