package org.healthplus.shop.presentation.dto.request;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;
import org.healthplus.shop.presentation.dto.response.OptionRetrievalResponse;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class OptionGroupRegistrationRequest {

  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private IsYn useYn;
  private List<OptionRegistrationRequest> options;
}
