package org.healthplus.shop.application.dto;

import lombok.Getter;
import org.healthplus.shop.domain.shop.Option;
import org.healthplus.shop.domain.shop.OptionGroup;
import org.healthplus.shop.domain.shop.enums.IsYn;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OptionGroupRegistrationData {

  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private List<OptionRegistrationData> optionDataList;

  public OptionGroup toOptionGroup() {
    List<Option> options = optionDataList.stream()
            .map(o -> o.toOption())
            .collect(Collectors.toList());

    return OptionGroup.builder()
            .basicChoiceYn(basicChoiceYn)
            .etcChoiceYn(etcChoiceYn)
            .options(options)
            .build();
  }



}
