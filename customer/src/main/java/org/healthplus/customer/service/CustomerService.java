package org.healthplus.customer.service;

import org.healthplus.customer.dto.CustomerInquiryDTO;
import org.healthplus.customer.dto.CustomerRegistrationDTO;
import org.healthplus.customer.enums.Result;

public interface CustomerService {
  Result registerCustomer(CustomerRegistrationDTO dto);

  CustomerInquiryDTO getCustomerProfile(Long customerId);
}
