package org.healthplus.shop.domain;

import lombok.Getter;
import org.healthplus.shop.entity.enums.IsYn;

import java.time.LocalDateTime;

@Getter
public class CategoryDomain {

  private Integer id;
  private String type;
  private LocalDateTime createdAt;
  private IsYn useYn;
}
