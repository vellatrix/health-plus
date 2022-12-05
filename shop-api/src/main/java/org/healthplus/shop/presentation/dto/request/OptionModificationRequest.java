package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

@Getter
public class OptionModificationRequest {

  private Long id;
  private Long optionGroupId;
  private String name;
  private Integer price;
  private Integer displayOrder;
  private IsYn useYn;
}
