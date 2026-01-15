package com.WanSoo.entity.university;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class AdmissionCut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 소속 학과
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    /**
     * 입시 전형 유형 (정시/수시 등)
     */
    @Column(nullable = false, length = 20)
    private String admissionType;

    /**
     * 합격 기준 점수 (환산 점수)
     */
    @Column(nullable = false)
    private double score;

    /**
     * 입시 연도
     */
    @Column(nullable = false)
    private int year;
}
