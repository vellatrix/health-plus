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
@Builder
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


}
