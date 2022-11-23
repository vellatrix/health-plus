package org.healthplus.user.infrastructure.inmemory;

import java.util.HashMap;
import java.util.Map;
import org.healthplus.user.domain.UserRepository;
import org.healthplus.user.domain.entity.User;

public class UserInMemoryAdapter implements UserRepository {

  private static Map<Long, User> userMap = new HashMap<>();
  private static Long sequence = 0L;

  @Override
  public User save(User user) {
    userMap.put(user.getUserId(), user);
    return user;
  }

  @Override
  public User findByEmail(String email) {
    for (User user : userMap.values()) {
      if (user.getEmail().equals(email)) {
        return user;
      }
    }
    return null;
  }

  @Override
  public boolean existsByEmail(String email) {
    for (User user : userMap.values()) {
      if (user.getEmail().equals(email)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean isMatchPassword(String password) {
    for (User user : userMap.values()) {
      if (user.getPassword().equals(password)) {
        return true;
      }
    }
    return false;
  }
}
