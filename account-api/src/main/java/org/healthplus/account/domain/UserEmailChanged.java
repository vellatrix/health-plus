package org.healthplus.account.domain;

import org.healthplus.model.domain.DomainEvent;


/*
 * aggregate으로부터 이벤트를 발행할 땐 이벤트의 이름에 과거 시점을 반영합니다.
 * */
public class UserEmailChanged extends DomainEvent {

}
