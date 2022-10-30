package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.enums.MenuType;

import java.util.List;

@Getter
@NoArgsConstructor
@Builder
public class ProductInfoRegistrationDTO {

  private Long categoryId;
  private String name;
  private Integer price;
  private String description;
  private Integer calorie;
  private String categoryType;
  private MenuType menuType;
  private List<ProductOptionGroupInfoDTO> optionGroup;

}
