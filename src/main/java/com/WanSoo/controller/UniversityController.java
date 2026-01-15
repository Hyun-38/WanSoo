package com.WanSoo.controller;

import com.WanSoo.dto.university.UniversityResponse;
import com.WanSoo.dto.university.UniversitySearchRequest;
import com.WanSoo.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    /**
     * 📌 대학 목록 조회 / 검색
     */
    @GetMapping
    public ResponseEntity<List<UniversityResponse>> search(
            UniversitySearchRequest request
    ) {
        return ResponseEntity.ok(
                universityService.search(request)
        );
    }

    /**
     * 🎯 수능 점수 기반 대학 추천
     */
    @PostMapping("/recommend")
    public ResponseEntity<List<UniversityResponse>> recommend(
            @RequestBody UniversitySearchRequest request
    ) {
        return ResponseEntity.ok(
                universityService.recommend(request)
        );
    }
}
