package com.WanSoo.entity.user;

import com.WanSoo.entity.score.SubjectScore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private int korean;
    private int math;
    private int english;

    @OneToMany(
            mappedBy = "userScore",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SubjectScore> inquiryScores = new ArrayList<>();

    /* 연관관계 편의 메서드 */
    public void assignUser(User user) {
        this.user = user;
    }

    public void addInquiryScore(SubjectScore score) {
        if (inquiryScores.size() >= 2) {
            throw new IllegalStateException("탐구 과목은 최대 2개만 선택할 수 있습니다.");
        }
        inquiryScores.add(score);
        score.assign(this);
    }
}

