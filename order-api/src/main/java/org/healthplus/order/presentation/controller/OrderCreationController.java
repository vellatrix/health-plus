package org.healthplus.order.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.order.application.service.OrderCreationService;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.presentation.convertor.OrderDtoConvertor;
import org.healthplus.order.presentation.dto.OrderCreationRequest;
import org.healthplus.order.presentation.dto.OrderCreationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderCreationController {

  private final OrderCreationService orderCreationService;

  @PostMapping
  public ApiResponse<OrderCreationResponse> registerOrder(@RequestBody @Valid OrderCreationRequest dto) {

    Order order = OrderDtoConvertor.toOrderCreationRequest(dto);
    Order savedOrder = orderCreationService.createOrder(order);
    OrderCreationResponse responseData = OrderDtoConvertor.toOrderCreationResponse(savedOrder);

    return ApiResponse.success(responseData);

  }

}
