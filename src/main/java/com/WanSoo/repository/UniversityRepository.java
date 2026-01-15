package com.WanSoo.repository;

import com.WanSoo.entity.university.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UniversityRepository extends JpaRepository<University, Long> {

    /**
     * 지역 기반 대학 조회
     */
    List<University> findByRegion(String region);

    /**
     * 대학명 포함 검색
     */
    List<University> findByNameContainingIgnoreCase(String name);
}
