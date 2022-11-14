package org.healthplus.user.domain;

import org.healthplus.user.domain.entity.RefreshToken;

public interface RefreshTokenRepository {

  RefreshToken findRefreshTokenByUserId(Long userId);

  RefreshToken saveRefreshToken(RefreshToken refreshToken);

  void deleteRefreshToken(Long userId);

}
