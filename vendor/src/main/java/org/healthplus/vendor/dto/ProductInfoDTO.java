package org.healthplus.vendor.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;

import java.util.List;

@Getter
@ToString
@Builder
public class ProductInfoDTO {

  private Long menuId;
  private String name;
  private String description;
  private Integer calorie;
  private IsYn soldYn;
  private IsYn useYn;
  private Integer price;
  private List<ProductOptionGroupInfoDTO> optionGroup;


}
