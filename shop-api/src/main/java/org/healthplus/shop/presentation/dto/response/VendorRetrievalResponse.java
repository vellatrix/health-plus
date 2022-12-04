package org.healthplus.shop.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VendorRetrievalResponse {

  private Long vendorId;
  private String email;
  private String phoneNumber;
  private String name;
  private String bank;
  private String accountNumber;
}
