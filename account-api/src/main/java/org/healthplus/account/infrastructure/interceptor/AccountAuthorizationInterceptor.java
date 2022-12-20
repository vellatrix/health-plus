package org.healthplus.account.infrastructure.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.healthplus.account.application.result.AuthorizationResult;
import org.healthplus.account.domain.Authorization;
import org.healthplus.account.domain.exception.MisMatchedRoleException;
import org.healthplus.account.domain.exception.NotLoggedInException;
import org.healthplus.model.role.Role;
import org.springframework.web.servlet.HandlerInterceptor;

/*
 * Application Account 인가를 위한 Class
 * */
@RequiredArgsConstructor
public class AccountAuthorizationInterceptor implements HandlerInterceptor {

  private final Authorization authorization;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    AuthorizationResult currentUser = authorization.getCurrentUser(request);
    if (currentUser == null) {
      throw new NotLoggedInException("로그인이 필요한 서비스입니다.");
    }

    if (!(currentUser.getCurrentRole().equals(Role.VENDOR)
        || currentUser.getCurrentRole().equals(Role.CUSTOMER)
        || currentUser.getCurrentRole().equals(Role.DELIVERY_WORKER))) {
      throw new MisMatchedRoleException("권한이 없는 사용자입니다.");
    }

    return true;
  }
}
