package com.WanSoo.repository;

import com.WanSoo.entity.user.User;
import com.WanSoo.entity.user.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserScoreRepository extends JpaRepository<UserScore, Long> {

    /**
     * 사용자 기준 점수 조회
     */
    Optional<UserScore> findByUser(User user);

    /**
     * 사용자 ID 기준 점수 조회
     */
    Optional<UserScore> findByUserId(Long userId);

    /**
     * 사용자 점수 존재 여부
     */
    boolean existsByUser(User user);
}
