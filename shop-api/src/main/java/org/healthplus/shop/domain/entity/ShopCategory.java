package org.healthplus.shop.domain.entity;

import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_category")
@Getter
public class ShopCategory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cate_id")
  private Integer id;

  private String type;

  @Column(name = "create_dt")
  private LocalDateTime createdAt;

  @Enumerated(EnumType.STRING)
  private IsYn useYn;

  public ShopCategory(Integer id) {
    this.id = id;
  }
}
