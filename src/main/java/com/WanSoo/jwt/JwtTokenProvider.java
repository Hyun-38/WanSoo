package com.WanSoo.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    private final Key secretKey;
    private final long tokenValidityInMs;

    // application.yml에서 secret key와 만료시간을 불러옴
    public JwtTokenProvider(
            @Value("${jwt.secret}") String secretKey,
            @Value("${jwt.token-expire-ms}") long tokenValidityInMs) {

        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.tokenValidityInMs = tokenValidityInMs;
    }

    /**
     * ✔ JWT 토큰 생성
     */
    public String generateToken(String email) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + tokenValidityInMs);

        return Jwts.builder()
                .setSubject(email)  // 토큰 내부 정보
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256) // HS256으로 서명
                .compact();
    }

    /**
     * ✔ 토큰에서 이메일(subject) 추출
     */
    public String getUserEmail(String token) {
        return parseClaims(token).getBody().getSubject();
    }

    /**
     * ✔ 토큰 유효성 검증
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (ExpiredJwtException e) {
            log.warn("JWT TOKEN 만료됨: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.warn("JWT TOKEN 형식이 옳지 않음: {}", e.getMessage());
        } catch (SignatureException e) {
            log.warn("JWT 서명 검증 실패: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.warn("JWT TOKEN 값 없음: {}", e.getMessage());
        }

        return false;
    }

    /**
     * 내부용 - Claims 파싱
     */
    private Jws<Claims> parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token);
    }
}
