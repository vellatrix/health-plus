package org.healthplus.user.infrastructure.persistence;

import java.util.HashMap;
import java.util.Map;
import org.healthplus.user.domain.UserRepository;
import org.healthplus.user.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {

  private Map<Long, User> userMap = new HashMap<>();
  private Long sequence = 0L;
  @Override
  public User save(User user) {
    userMap.put(user.getUserId(), user);
    return user;
  }

  @Override
  public boolean existUser(String id) {
    for (User user : userMap.values()) {
      if (user.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean matchPassword(String password) {
    return false;
  }

  @Override
  public User findUserById(String id) {
    for (User user : userMap.values()) {
      if (user.getId().equals(id)) {
        return user;
      }
    }
    return null;
  }
}
