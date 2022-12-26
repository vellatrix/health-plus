package org.healthplus.order.presentation.convertor;

import org.healthplus.order.domain.entity.Address;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.domain.entity.OrderLines;
import org.healthplus.order.domain.entity.OrderOption;
import org.healthplus.order.domain.entity.OrderOptionGroup;
import org.healthplus.order.presentation.dto.OrderCreationOptionRequest;
import org.healthplus.order.presentation.dto.OrderCreationRequest;
import org.healthplus.order.presentation.dto.OrderCreationResponse;
import org.healthplus.order.presentation.dto.OrderLineCreationRequest;
import org.healthplus.order.presentation.dto.OrderOptionGroupCreationRequest;
import org.healthplus.order.presentation.dto.OrderPaymentRequest;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDtoConvertor {

  public static Order toOrderCreationRequest(OrderCreationRequest dto) {
    return Order.builder()
            .customerId(dto.getCustomerId())
            .shopId(dto.getShopId())
            .riderId(0L)
            .totalPrice(dto.getTotalPrice())
            .deliveryFee(dto.getDeliveryFee())
            .address(new Address(dto.getCity(), dto.getStreet(), dto.getZipCode()))
            .orderLines(toOrderLines(dto.getOrderLines()))
            .build();
  }

  private static List<OrderLines> toOrderLines(List<OrderLineCreationRequest> orderLines) {
    return orderLines.stream()
            .map(ol -> new OrderLines(ol.getName(), ol.getPrice(), ol.getQuantity(), toOrderOptionGroup(ol.getOptionGroups())))
            .collect(Collectors.toList());
  }

  private static List<OrderOptionGroup> toOrderOptionGroup(List<OrderOptionGroupCreationRequest> optionGroups) {
    return optionGroups.stream()
            .map(og -> new OrderOptionGroup(og.getName(), toOrderOption(og.getOrderOptions())))
            .collect(Collectors.toList());
  }

  private static List<OrderOption> toOrderOption(List<OrderCreationOptionRequest> orderOptions) {
    return orderOptions.stream()
            .map(o -> new OrderOption(o.getName(), o.getPrice()))
            .collect(Collectors.toList());
  }

  public static OrderCreationResponse toOrderCreationResponse(Order order) {
    List<String> menuNames = order.getOrderLines().stream()
            .map(ol -> String.format("메뉴명 = %s / 수량 = %d개", ol.getName(), ol.getQuantity()))
            .collect(Collectors.toList());

    return OrderCreationResponse.builder()
            .orderId(order.getId())
            .customerId(order.getCustomerId())
            .shopId(order.getShopId())
            .amount(order.getTotalPrice())
            .deliveryFee(order.getDeliveryFee())
            .menuName(menuNames)
            .build();
  }

  public static Order fromOrderPaymentRequest(OrderPaymentRequest dto) {
    return Order.toPaymentRequest(dto.getOrderId(), dto.getAmount());
  }
}
