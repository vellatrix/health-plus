package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class MenuModificationRequest {
  private Long id;
  private Long shopId;
  private Integer categoryId;
  private String name;
  private Character type;
  private Integer price;
  private String description;
  private String category;
  private List<OptionGroupModificationRequest> optionGroups;

}
