package org.healthplus.account.infrastructure.auth;

import javax.servlet.http.HttpSession;
import org.healthplus.account.application.command.AuthorizationCommand;
import org.healthplus.account.domain.Authorization;
import org.healthplus.account.domain.SessionValueVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
 * Authorization Interface를 이용해 의존성 역전 -> 확작성 있게 설계됨
 * */
@Component
public class SessionAuthorization implements Authorization {

  private static final String HEALTH_PLUS_ACCOUNT_SESSION_VALUE = "HEALTH_PLUS_ACCOUNT_SESSION_VALUE";

  private HttpSession httpSession;

  @Autowired
  public SessionAuthorization(HttpSession httpSession) {
    this.httpSession = httpSession;
  }

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
}
