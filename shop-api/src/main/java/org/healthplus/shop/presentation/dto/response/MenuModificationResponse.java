package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MenuModificationResponse {
  private Long id;
  private Long shopId;
  private Integer categoryId;
  private String name;
  private Character type;
  private Integer price;
  private String description;
  private String category;
  private List<OptionGroupModificationResponse> optionGroups;

}
