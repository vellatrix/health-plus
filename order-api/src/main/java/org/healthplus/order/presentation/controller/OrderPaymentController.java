package org.healthplus.order.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.order.application.service.OrderPaymentService;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.presentation.convertor.OrderDtoConvertor;
import org.healthplus.order.presentation.dto.OrderPaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderPaymentController {

  private final OrderPaymentService orderPaymentService;

  @PostMapping("/{orderId}/payment")
  public ApiResponse<Void> payOrder(@RequestBody @Valid OrderPaymentRequest dto) {

    Order order = OrderDtoConvertor.toOrderPaymentRequest(dto);
    orderPaymentService.pay(order);

    return ApiResponse.success(null);

  }

}
