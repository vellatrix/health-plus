package org.healthplus.order.presentation.convertor;

import org.healthplus.order.domain.entity.Address;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.presentation.dto.OrderCreationRequest;

public class OrderDtoConvertor {

  public static Order toOrderCreation(OrderCreationRequest dto) {
    return Order.builder()
            .customerId(dto.getCustomerId())
            .shopId(dto.getShopId())
            .riderId(0L)
            .totalPrice(dto.getTotalPrice())
            .address(new Address(dto.getCity(), dto.getStreet(), dto.getZipCode()))
            .build();
  }
}
