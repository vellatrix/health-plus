package org.healthplus.account.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.healthplus.account.domain.Authorization;
import org.healthplus.account.infrastructure.interceptor.AccountAuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

  private final Authorization authorization;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new AccountAuthorizationInterceptor(authorization))
        .addPathPatterns("/customer/*", "/delivery/*", "/notification/*")
        .excludePathPatterns("/api/auth/user/signup", "/api/auth/user/signin");

  }
}
