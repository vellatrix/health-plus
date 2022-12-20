package org.healthplus.account.application;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.healthplus.account.application.command.AuthorizationCommand;
import org.healthplus.account.application.result.AuthorizationResult;
import org.healthplus.account.domain.Authorization;
import org.healthplus.account.domain.vo.SessionValueVO;
import org.springframework.stereotype.Component;


/*
 * Authorization Interface를 이용해 의존성 역전 -> 확작성 있게 설계됨
 * */
@Component
@RequiredArgsConstructor
public class SessionAuthorization implements Authorization {

  private static final String HEALTH_PLUS_ACCOUNT_SESSION_VALUE = "HEALTH_PLUS_ACCOUNT_SESSION_VALUE";

  private final HttpSession httpSession;

  @Override
  public String login(AuthorizationCommand authorizationCommand) {
    SessionValueVO sessionValueVO = new SessionValueVO(
        authorizationCommand.getUserId(),
        authorizationCommand.getEmail(),
        authorizationCommand.getRole()
    );
    httpSession.setAttribute(HEALTH_PLUS_ACCOUNT_SESSION_VALUE, sessionValueVO);
    return null;
  }

  @Override
  public AuthorizationResult getCurrentUser(HttpServletRequest request) {
    SessionValueVO sessionValue = (SessionValueVO) request.getSession()
        .getAttribute(HEALTH_PLUS_ACCOUNT_SESSION_VALUE);

    if (sessionValue == null) {
      return null;
    }
    return AuthorizationResult.fromSessionValue(sessionValue);
  }

  @Override
  public void logout(HttpServletRequest request) {
    request.getSession().invalidate();
  }
}
