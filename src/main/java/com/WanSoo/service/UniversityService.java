package com.WanSoo.service;

import com.WanSoo.dto.university.UniversityResponse;
import com.WanSoo.dto.university.UniversitySearchRequest;
import com.WanSoo.entity.university.AdmissionCut;
import com.WanSoo.entity.university.Department;
import com.WanSoo.entity.university.University;
import com.WanSoo.repository.AdmissionCutRepository;
import com.WanSoo.repository.DepartmentRepository;
import com.WanSoo.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UniversityService {

    private final UniversityRepository universityRepository;
    private final DepartmentRepository departmentRepository;
    private final AdmissionCutRepository admissionCutRepository;

    /**
     * 대학 검색
     */
    public List<UniversityResponse> search(UniversitySearchRequest request) {

        List<University> universities;

        if (request.getUniversityName() != null) {
            universities = universityRepository
                    .findByNameContainingIgnoreCase(request.getUniversityName());
        } else if (request.getRegion() != null) {
            universities = universityRepository.findByRegion(request.getRegion());
        } else {
            universities = universityRepository.findAll();
        }

        return universities.stream()
                .flatMap(u -> departmentRepository
                        .findByUniversity(u).stream())
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * 수능 점수 기반 추천 (기본 틀)
     */
    public List<UniversityResponse> recommend(UniversitySearchRequest request) {

        // 지금은 검색 기반 추천
        // 이후 UserScore + ScoreWeight 로직으로 확장
        return search(request);
    }

    private UniversityResponse toResponse(Department department) {

        AdmissionCut cut = admissionCutRepository
                .findTopByDepartmentOrderByYearDesc(department)
                .orElse(null);

        return UniversityResponse.builder()
                .universityId(department.getUniversity().getId())
                .universityName(department.getUniversity().getName())
                .departmentName(department.getName())
                .region(department.getUniversity().getRegion())
                .admissionScore(cut != null ? cut.getScore() : 0)
                .build();
    }
}
