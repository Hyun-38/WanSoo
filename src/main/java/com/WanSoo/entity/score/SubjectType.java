package com.WanSoo.entity.score;

public enum SubjectType {

    // 사회탐구
    EAST_ASIAN_HISTORY(SubjectCategory.SOCIAL), //동아시아사
    WORLD_HISTORY(SubjectCategory.SOCIAL), //세계사
    ECONOMICS(SubjectCategory.SOCIAL), //경제
    SOCIETY_CULTURE(SubjectCategory.SOCIAL), //사문
    POLITICS_AND_LAW(SubjectCategory.SOCIAL), //정치와법
    LIFE_AND_ETHICS(SubjectCategory.SOCIAL), //생활과윤리
    KOREAN_GEOGRAPHY(SubjectCategory.SOCIAL), //한국지리
    WORLD_GEOGRAPHY(SubjectCategory.SOCIAL),

    // 과학탐구
    PHYSICS1(SubjectCategory.SCIENCE),
    CHEMISTRY1(SubjectCategory.SCIENCE),
    BIOLOGY1(SubjectCategory.SCIENCE),
    EARTH_SCIENCE1(SubjectCategory.SCIENCE),
    PHYSICS2(SubjectCategory.SCIENCE),
    CHEMISTRY2(SubjectCategory.SCIENCE),
    BIOLOGY2(SubjectCategory.SCIENCE),
    EARTH_SCIENCE2(SubjectCategory.SCIENCE);

    private final SubjectCategory category;

    SubjectType(SubjectCategory category) {
        this.category = category;
    }

    public SubjectCategory getCategory() {
        return category;
    }
}
