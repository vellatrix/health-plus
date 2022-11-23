package org.healthplus.user.infrastructure.jpa;

import lombok.RequiredArgsConstructor;
import org.healthplus.user.domain.RefreshTokenRepository;
import org.healthplus.user.domain.entity.RefreshToken;

@RequiredArgsConstructor
public class JpaRefreshTokenRepositoryAdapter implements RefreshTokenRepository {

    private final JpaRefreshTokenRepository jpaRefreshTokenRepository;

    @Override
    public RefreshToken findRefreshTokenByUserId(Long userId) {
        return null;
    }

    @Override
    public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
        return jpaRefreshTokenRepository.save(refreshToken);
    }

    @Override
    public void deleteRefreshToken(Long userId) {

    }
}
