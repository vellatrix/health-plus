package org.healthplus.account.infrastructure.Impl.hashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;
import org.healthplus.account.domain.User;
import org.healthplus.account.domain.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class HashMapUserRepositoryImpl implements UserRepository {

  private final Map<Long, User> userMap = new ConcurrentHashMap<>();
  private final AtomicLong id = new AtomicLong();

  @Override
  public User save(User user) {
    if (user.getId() == null || user.getId() <= 0L) {
      Long userId = id.incrementAndGet();
      user.setId(userId);
      userMap.put(userId, user);
    } else {
      userMap.put(user.getId(), user);
    }
    return user;
  }

  @Override
  public User findByEmail(String userEmail) {
    return userMap.values()
        .stream().filter(user -> userEmail.equals(user.getEmail()))
        .findFirst().orElse(null);
  }
}
