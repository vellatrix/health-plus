package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.healthplus.shop.domain.enums.IsYn;

import java.util.List;

@Getter
@Builder
public class MenuRetrievalResponse {

  private Long id;
  private Long shopId;
  private Integer categoryId;
  private String name;
  private String type;
  private Integer price;
  private String description;
  private String category;
  private IsYn soldYn;
  private IsYn useYn;
  private List<OptionGroupRetrievalResponse> optionGroups;

}
