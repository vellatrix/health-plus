package org.healthplus.order.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.model.result.ApiResponse;
import org.healthplus.order.application.service.OrderCreationService;
import org.healthplus.order.domain.entity.Order;
import org.healthplus.order.presentation.convertor.OrderDtoConvertor;
import org.healthplus.order.presentation.dto.OrderCreationRequest;
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
  public void registerOrder(@RequestBody @Valid OrderCreationRequest dto) {

    Order order = OrderDtoConvertor.toOrderCreation(dto);
    orderCreationService.createOrder(order);

  }

}
