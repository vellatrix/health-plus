package org.healthplus.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Ping {

  @GetMapping("/ping")
  public String answer() {
    System.out.println("Ping");
    log.info("Ping is successful");
    return "pong";
  }
}
