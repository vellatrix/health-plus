package org.healthplus.shop.presentation.dto.request;

import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

import java.util.List;

@Getter
public class OptionGroupModificationRequest {

  private Long id;
  private Long menuId;
  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private IsYn useYn;
  private List<OptionModificationRequest> options;
}
