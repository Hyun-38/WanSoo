package com.WanSoo.service;

import com.WanSoo.dto.university.MockApplyRequest;
import com.WanSoo.dto.university.MockApplyResultResponse;
import com.WanSoo.entity.university.AdmissionCut;
import com.WanSoo.entity.university.Department;
import com.WanSoo.repository.AdmissionCutRepository;
import com.WanSoo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MockApplyService {

    private final DepartmentRepository departmentRepository;
    private final AdmissionCutRepository admissionCutRepository;

    /**
     * 가상 지원 결과 계산
     */
    public MockApplyResultResponse apply(
            MockApplyRequest request,
            double myScore
    ) {

        Department department = departmentRepository.findById(
                        request.getDepartmentId())
                .orElseThrow(() ->
                        new IllegalArgumentException("학과를 찾을 수 없습니다.")
                );

        AdmissionCut cut = admissionCutRepository
                .findTopByDepartmentOrderByYearDesc(department)
                .orElseThrow(() ->
                        new IllegalArgumentException("합격 컷 정보가 없습니다.")
                );

        boolean passed = myScore >= cut.getScore();

        return MockApplyResultResponse.builder()
                .universityName(department.getUniversity().getName())
                .departmentName(department.getName())
                .myScore(myScore)
                .cutLine(cut.getScore())
                .passed(passed)
                .build();
    }
}
