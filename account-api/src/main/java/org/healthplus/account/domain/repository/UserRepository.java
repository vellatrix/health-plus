package org.healthplus.account.domain.repository;

import org.healthplus.account.domain.entity.User;

public interface UserRepository {

  User save(User user);

  User findByEmail(String userEmail);
}
