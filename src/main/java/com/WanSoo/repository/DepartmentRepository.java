package com.WanSoo.repository;

import com.WanSoo.entity.university.Department;
import com.WanSoo.entity.university.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * 특정 대학의 학과 목록 조회
     */
    List<Department> findByUniversity(University university);

    /**
     * 대학 + 학과명으로 단건 조회
     */
    Optional<Department> findByUniversityAndName(
            University university,
            String name
    );
}
