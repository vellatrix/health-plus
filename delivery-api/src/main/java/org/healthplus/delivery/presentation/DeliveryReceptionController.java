package org.healthplus.delivery.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryReceptionController {

  // TODO: 2022/12/21 order에서 결제가 끝나고 발행된 주문 이벤트를 이곳에서 처리
  @PostMapping("/reception")
  public String reception() {
    return "Hello world";
  }
}
