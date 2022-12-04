package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

@Getter
@Builder
public class OptionRetrievalResponse {

  private Long id;
  private Long optionGroupId;
  private String name;
  private Integer price;
  private Integer displayOrder;
  private IsYn useYn;
}
