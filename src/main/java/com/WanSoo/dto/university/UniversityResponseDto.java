package com.WanSoo.dto.university;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UniversityResponseDto {

    private Long universityId;
    private String universityName;
    private String departmentName;
    private String region;
    private double admissionScore;
}
