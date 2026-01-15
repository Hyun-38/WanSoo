package com.WanSoo.repository;

import com.WanSoo.entity.university.ScoreWeight;
import com.WanSoo.entity.university.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreWeightRepository extends JpaRepository<ScoreWeight, Long> {

    /**
     * 학과별 수능 반영 비율 조회
     */
    Optional<ScoreWeight> findByDepartment(Department department);
}
