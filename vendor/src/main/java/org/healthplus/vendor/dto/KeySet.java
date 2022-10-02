package org.healthplus.vendor.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class KeySet {

  private Long restaurantId;
  private List<Long> menuId;
  private List<Long> optionGroupId;
  private List<Long> optionDetailId;
}
