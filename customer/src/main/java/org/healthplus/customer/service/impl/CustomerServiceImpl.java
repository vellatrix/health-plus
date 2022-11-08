package org.healthplus.customer.service.impl;

import lombok.RequiredArgsConstructor;
import org.healthplus.customer.dto.CustomerInquiryDTO;
import org.healthplus.customer.dto.CustomerRegistrationDTO;
import org.healthplus.customer.entity.Cart;
import org.healthplus.customer.entity.Customer;
import org.healthplus.customer.enums.Result;
import org.healthplus.customer.exception.CustomException;
import org.healthplus.customer.exception.ErrorCode;
import org.healthplus.customer.repository.CartRepository;
import org.healthplus.customer.repository.CustomerRepository;
import org.healthplus.customer.service.CustomerService;
import org.healthplus.customer.util.CartDataConvertor;
import org.healthplus.customer.util.CustomerDataConvertor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CartRepository cartRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public Result registerCustomer(CustomerRegistrationDTO dto) {

    String password = passwordEncoder.encode(dto.getPassword());

    Customer customer = CustomerDataConvertor.createCustomer(dto, password);
    Customer savedCustomer = customerRepository.save(customer);

    if(savedCustomer == null) return Result.FAIL;
    else return Result.SUCCESS;
  }

  @Override
  public CustomerInquiryDTO getCustomerProfile(Long customerId) {

    Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new CustomException(ErrorCode.INVALID_CUSTOMER));

    List<Cart> cartList = cartRepository.findAllByCustomerId(customer.getCustomerId());

    // 메뉴 이름 및 아이디 가져오기

    CartDataConvertor.convertCartInfoToDto(cartList);
    // 합치기

    return CustomerDataConvertor.convertCustomerInfoToDto(customer);
  }


}
