package com.WanSoo.repository;

import com.WanSoo.entity.university.AdmissionCut;
import com.WanSoo.entity.university.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmissionCutRepository extends JpaRepository<AdmissionCut, Long> {

    /**
     * 학과별 최신 합격 컷 조회
     */
    Optional<AdmissionCut> findTopByDepartmentOrderByYearDesc(
            Department department
    );
}
