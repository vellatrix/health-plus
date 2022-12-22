package org.healthplus.delivery.domain.exception;

public class VehicleTypeMisMatchException extends RuntimeException {

  public VehicleTypeMisMatchException() {
  }

  public VehicleTypeMisMatchException(String message) {
    super(message);
  }
}
