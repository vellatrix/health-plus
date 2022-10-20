package org.healthplus.vendor.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;

import java.util.List;

@Getter
@ToString
public class ProductInfoListDTO {

  private Long menuId;
  private String name;
  private String description;
  private Integer calorie;
  private IsYn soldYn;
  private IsYn useYn;
  private Integer price;
  private List<ProductOptionGroupInfoDTO> optionGroup;

  public ProductInfoListDTO(List<ProductOptionGroupInfoDTO> optionGroup) {
    this.optionGroup = optionGroup;
  }

  @Builder
  public ProductInfoListDTO(Long menuId,
                            String name,
                            String description,
                            Integer calorie,
                            IsYn soldYn,
                            IsYn useYn,
                            Integer price,
                            List<ProductOptionGroupInfoDTO> optionGroup) {
    this.menuId = menuId;
    this.name = name;
    this.description = description;
    this.calorie = calorie;
    this.soldYn = soldYn;
    this.useYn = useYn;
    this.price = price;
    this.optionGroup = optionGroup;
  }
}
