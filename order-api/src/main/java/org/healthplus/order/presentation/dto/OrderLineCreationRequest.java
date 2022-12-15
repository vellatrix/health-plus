package org.healthplus.order.presentation.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderLineCreationRequest {

  private String name;
  private Integer price;
  private Integer quantity;
  private List<OrderOptionGroupCreationRequest> optionGroups;
}
