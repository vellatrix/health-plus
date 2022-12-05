package org.healthplus.account.domain;

import org.healthplus.account.application.command.AuthorizationCommand;
import org.healthplus.model.role.Role;

/*
* 인가와 관련된 명세를 정의합니다.
* 인증, 인가에 관련된 도메인 규칙을 갖고 있으며 해당 비지니스를 해결하기
* 위해 필요한 것을 모아둔 도메인 계층에 정의합니다.
* */
public interface Authorization {

  String login(AuthorizationCommand authorizationCommand);

}
