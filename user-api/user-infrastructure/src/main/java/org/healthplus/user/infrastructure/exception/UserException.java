package org.healthplus.user.infrastructure.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserException extends RuntimeException {

    private final ErrorCode errorCode;
}
