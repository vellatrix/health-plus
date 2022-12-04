package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;
import org.healthplus.shop.domain.enums.Type;

import java.util.List;

@Getter
public class MenuRegistrationRequest {

  private Long shopId;
  private Integer categoryId;
  private String name;
  private Type type;
  private Integer price;
  private String description;
  private List<OptionGroupRegistrationRequest> optionGroups;
}
