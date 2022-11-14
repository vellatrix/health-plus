package org.healthplus.user.infrastructure.security.persistence;

import java.util.HashMap;
import java.util.Map;
import org.healthplus.user.domain.RefreshTokenRepository;
import org.healthplus.user.domain.entity.RefreshToken;
import org.springframework.stereotype.Component;

@Component
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {

  private Map<Long, RefreshToken> refreshTokenMap = new HashMap<>();

  @Override
  public RefreshToken findRefreshTokenByUserId(Long userId) {
    return null;
  }

  @Override
  public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
    return null;
  }

  @Override
  public void deleteRefreshToken(Long userId) {

  }
}
