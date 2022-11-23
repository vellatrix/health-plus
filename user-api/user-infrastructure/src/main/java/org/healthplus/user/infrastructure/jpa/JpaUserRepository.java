package org.healthplus.user.infrastructure.jpa;

import java.util.Optional;
import org.healthplus.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
