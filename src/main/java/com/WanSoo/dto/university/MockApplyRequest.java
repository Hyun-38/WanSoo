package com.WanSoo.dto.university;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MockApplyRequest {

    @NotNull
    private Long universityId;

    @NotNull
    private Long departmentId;
    private double score;
}
