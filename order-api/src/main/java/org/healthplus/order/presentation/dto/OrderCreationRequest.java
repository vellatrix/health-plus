package org.healthplus.order.presentation.dto;

import lombok.Getter;

@Getter
public class OrderCreationRequest {

  private Long customerId;
  private Long shopId;
  private Long riderId;
  private Integer totalPrice;
  private Integer deliveryFee;
  private String city;
  private String street;
  private String zipCode;
}
