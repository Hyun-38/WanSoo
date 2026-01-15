package com.WanSoo.entity.score;

import com.WanSoo.entity.user.UserScore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class SubjectScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 과목 종류 (물리, 화학, 경제 등)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubjectType subjectType;

    /**
     * 과목 계열 (과탐 / 사탐)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SubjectCategory category;

    /**
     * 점수
     */
    @Column(nullable = false)
    private int score;

    /**
     * 사용자 수능 점수와의 연관관계
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_score_id")
    private UserScore userScore;

    /* ================= 연관관계 편의 메서드 ================= */

    public void assign(UserScore userScore) {
        this.userScore = userScore;
    }
}
