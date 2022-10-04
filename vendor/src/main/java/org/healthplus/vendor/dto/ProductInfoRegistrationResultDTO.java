package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.model.entity.CommonDateTime;
import org.healthplus.vendor.entity.Menu;
import org.healthplus.vendor.entity.OptionDetail;
import org.healthplus.vendor.entity.OptionGroup;
import org.healthplus.vendor.enums.Category;
import org.healthplus.vendor.enums.IsYn;
import org.healthplus.vendor.enums.MenuType;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@ToString
public class ProductInfoRegistrationResultDTO {

  private Long menuId;
  private Long restaurantId;
  private String category;
  private String type;
  private String description;
  private IsYn soldYn;
  private IsYn useYn;
  private LocalDateTime createdAt;
  private String name;
  private Integer price;
  private Integer calorie;
  private List<ProductOptionDetailInfoDTO> optionDetails;

  public static ProductInfoRegistrationResultDTO addProduct(Menu savedMenu,
                                                            List<OptionDetail> savedOptionDetails) {
    return ProductInfoRegistrationResultDTO.builder()
            .menuId(savedMenu.getMenuId())
            .restaurantId(savedMenu.getRestaurantId())
            .category(Category.selectCategoryName(savedMenu.getCategoryId()))
            .type(savedMenu.getMenuType().name())
            .description(savedMenu.getDescription())
            .soldYn(savedMenu.getSoldYn())
            .useYn(savedMenu.getUseYn())
            .createdAt(savedMenu.getCommonDateTime().getCreatedAt())
            .name(savedMenu.getName())
            .price(savedMenu.getPrice())
            .calorie(savedMenu.getCalorie())
            .optionDetails(OptionDetail.toDTO(savedOptionDetails))
            .build();
  }
}
