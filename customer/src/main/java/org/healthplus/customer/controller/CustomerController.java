package org.healthplus.customer.controller;

import lombok.RequiredArgsConstructor;
import org.healthplus.customer.service.CustomerService;
import org.healthplus.vendor.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;
  private final MenuService menuService;

  // 가입
  /*@PostMapping()
  public Result registerCustomer(@RequestBody CustomerRegistrationDTO dto) {
    return customerService.registerCustomer(dto);
  }*/

  // 조회
  /*@GetMapping("/{customerId}")
  public CustomerInquiryDTO retrieveCustomer(@PathVariable Long customerId) {


    return customerService.getCustomerProfile(customerId);
  }*/


  // 변경

  // 삭제

  // 주문

  // 장바구니 담기

  // 중복 확인
}
