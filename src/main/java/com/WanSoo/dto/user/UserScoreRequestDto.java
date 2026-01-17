package com.WanSoo.dto.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserScoreRequestDto {

    @Min(0) @Max(100)
    private double korean;

    @Min(0) @Max(100)
    private double math;

    @Min(0) @Max(100)
    private double english;

    @Min(0) @Max(100)
    private double social;

    @Min(0) @Max(100)
    private double science;

    @Min(0) @Max(100)
    private double history;
}
