package org.healthplus.vendor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.healthplus.vendor.enums.IsYn;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ProductOptionGroupInfoDTO {

  private Long optionGroupId;
  private String name;
  private IsYn basicChoiceYn;
  private IsYn etcChoiceYn;
  private List<ProductOptionDetailInfoDTO> optionDetails;

  public ProductOptionGroupInfoDTO(List<ProductOptionDetailInfoDTO> optionDetails) {
    this.optionDetails = optionDetails;
  }

  public ProductOptionGroupInfoDTO(String name,
                                   IsYn basicChoiceYn,
                                   IsYn etcChoiceYn,
                                   List<ProductOptionDetailInfoDTO> optionDetails) {
    this.name = name;
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.optionDetails = optionDetails;
  }

  @Builder
  public ProductOptionGroupInfoDTO(Long optionGroupId,
                                   String name,
                                   IsYn basicChoiceYn,
                                   IsYn etcChoiceYn,
                                   List<ProductOptionDetailInfoDTO> optionDetails) {
    this.optionGroupId = optionGroupId;
    this.name = name;
    this.basicChoiceYn = basicChoiceYn;
    this.etcChoiceYn = etcChoiceYn;
    this.optionDetails = optionDetails;
  }

}
