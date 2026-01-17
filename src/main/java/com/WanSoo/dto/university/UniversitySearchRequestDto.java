package com.WanSoo.dto.university;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UniversitySearchRequestDto {

    private String universityName;
    private String departmentName;
    private String region;
}
