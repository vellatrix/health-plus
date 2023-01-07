package org.healthplus.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

  @GetMapping("/ping")
  public String answer() {
    return "pong";
  }
}
