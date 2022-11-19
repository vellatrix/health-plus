package org.healthplus.shop.application.dto;

import lombok.Getter;
import org.healthplus.shop.domain.shop.Menu;
import org.healthplus.shop.domain.shop.Money;


@Getter
public class MenuData {

  private Integer categoryId;
  private Character type;
  private String name;
  private Integer price;
  private String description;

}
