package org.healthplus.user.domain;

import org.healthplus.user.domain.entity.User;

public interface UserRepository {

  /*
  * return its entity 는 더 풍부한 행위를 할 수 있다.
  * */
  User save(User user);

  boolean existUser(String id);

  boolean matchPassword(String password);

  User findUserById(String id);
}
