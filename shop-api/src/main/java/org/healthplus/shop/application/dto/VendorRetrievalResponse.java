package org.healthplus.shop.application.dto;

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
