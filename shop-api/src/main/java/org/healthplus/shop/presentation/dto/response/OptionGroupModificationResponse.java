package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

import java.util.List;

@Getter
@Builder
public class OptionGroupModificationResponse {

  private Long id;
  private Long menuId;
  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private IsYn useYn;
  private List<OptionModificationResponse> options;
}
