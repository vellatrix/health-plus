package org.healthplus.deliveryworker.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeliveryWorkerException extends RuntimeException {

    private final ErrorCode errorCode;
}
