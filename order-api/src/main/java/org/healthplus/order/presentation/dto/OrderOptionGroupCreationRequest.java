package org.healthplus.order.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderOptionGroupCreationRequest {

  private String name;
  private List<OrderCreationOptionRequest> orderOptions;

}
