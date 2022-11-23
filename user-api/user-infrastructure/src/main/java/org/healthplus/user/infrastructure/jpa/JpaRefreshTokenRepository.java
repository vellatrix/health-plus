package org.healthplus.user.infrastructure.jpa;

import org.healthplus.user.domain.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

}
