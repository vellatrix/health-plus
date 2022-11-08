package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.entity.OptionGroup;
import org.healthplus.vendor.enums.IsYn;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class ProductInfoRegistrationResultDTO {

  private Long menuId;
  private Long restaurantId;
  private Long categoryId;
  private String type;
  private String description;
  private IsYn soldYn;
  private IsYn useYn;
  private LocalDateTime createdAt;
  private String name;
  private Integer price;
  private Integer calorie;
  private List<ProductOptionGroupInfoDTO> optionGroups;

}
