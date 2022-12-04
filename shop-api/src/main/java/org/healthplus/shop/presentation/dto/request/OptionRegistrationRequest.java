package org.healthplus.shop.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

@Getter
@Builder
public class OptionRegistrationRequest {

  private String name;
  private Integer price;
  private Integer displayOrder;
  private IsYn useYn;
}
