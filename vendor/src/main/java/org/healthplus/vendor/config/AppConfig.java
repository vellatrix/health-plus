package org.healthplus.vendor.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

  private final EntityManager em;

}
