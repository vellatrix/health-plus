package org.healthplus.vendor.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.dto.ProductInfoDTO;
import org.healthplus.vendor.dto.ProductOptionGroupInfoDTO;
import org.healthplus.vendor.enums.IsYn;
import org.healthplus.vendor.enums.MenuType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "menu")
@NoArgsConstructor
public class Menu {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "menu_id")
  private Long menuId;

  @Column(name = "restaurant_id")
  private Long restaurantId;

  @Column(name = "category_id")
  private Long categoryId;

  @Enumerated(EnumType.STRING)
  @Column(name = "menu_type")
  private MenuType menuType;

  @Enumerated(EnumType.STRING)
  @Column(name = "sold_yn")
  private IsYn soldYn;

  @Enumerated(EnumType.STRING)
  @Column(name = "use_yn")
  private IsYn useYn;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Column(name = "modify_dt")
  private LocalDateTime modifiedAt;

  @Column(name = "name")
  private String name;

  @Column(name = "price")
  private Integer price;

  @Column(name = "stock")
  private Integer stock;

  @Column(name = "calorie")
  private Integer calorie;

  @Column(name = "description")
  private String description;

  @Builder
  public Menu(Long restaurantId,
              Long categoryId,
              String name,
              Integer price,
              Integer calorie,
              String description,
              MenuType menuType) {
    this.restaurantId = restaurantId;
    this.categoryId = categoryId;
    this.createdAt = LocalDateTime.now();
    this.name = name;
    this.price = price;
    this.calorie = calorie;
    this.description = description;
    this.menuType = menuType;
    this.soldYn = IsYn.Y;
    this.useYn = IsYn.Y;
  }


  @Builder
  public Menu(Long menuId,
              IsYn soldYn,
              IsYn useYn,
              String name,
              Integer price,
              Integer calorie,
              String description) {
    this.menuId = menuId;
    this.soldYn = soldYn;
    this.useYn = useYn;
    this.name = name;
    this.price = price;
    this.calorie = calorie;
    this.description = description;
  }

  public static ProductInfoDTO toDTO(Menu menu, List<ProductOptionGroupInfoDTO> optionGroupDtoList) {
    return ProductInfoDTO.builder()
            .menuId(menu.getMenuId())
            .name(menu.getName())
            .price(menu.getPrice())
            .description(menu.getDescription())
            .useYn(menu.getUseYn())
            .soldYn(menu.getSoldYn())
            .calorie(menu.getCalorie())
            .optionGroup(optionGroupDtoList)
            .build();
  }

  public ProductInfoDTO toMenuListDto() {
    return ProductInfoDTO.builder()
            .name(name)
            .price(price)
            .calorie(calorie)
            .description(description)
            .soldYn(soldYn)
            .useYn(useYn)
            .build();
  }
}
