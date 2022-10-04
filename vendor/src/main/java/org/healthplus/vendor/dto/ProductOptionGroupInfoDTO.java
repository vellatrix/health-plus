package org.healthplus.vendor.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ProductOptionGroupInfoDTO {

  private List<ProductOptionDetailInfoDTO> optionDetails;

  public ProductOptionGroupInfoDTO(List<ProductOptionDetailInfoDTO> optionDetails) {
    this.optionDetails = optionDetails;
  }
}
