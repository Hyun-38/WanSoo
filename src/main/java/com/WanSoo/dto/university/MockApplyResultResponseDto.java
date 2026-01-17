package com.WanSoo.dto.university;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MockApplyResultResponseDto {

    private String universityName;
    private String departmentName;
    private double myScore;
    private double cutLine;
    private boolean passed;
}
