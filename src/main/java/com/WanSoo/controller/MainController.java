package com.WanSoo.controller;

import com.WanSoo.dto.user.UserLoginRequest;
import com.WanSoo.dto.user.UserResponse;
import com.WanSoo.dto.user.UserSignupRequest;
import com.WanSoo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final AuthService authService;

    /**
     * 🔹 메인 API
     */
    @GetMapping
    public ResponseEntity<String> main() {
        return ResponseEntity.ok("WanSoo 수능 분석 서비스 API");
    }

    /**
     * 🔐 회원가입
     */
    @PostMapping("/auth/signup")
    public ResponseEntity<UserResponse> signup(
            @RequestBody UserSignupRequest request
    ) {
        return ResponseEntity.ok(
                authService.signup(request)
        );
    }

    /**
     * 🔐 로그인
     */
    @PostMapping("/auth/login")
    public ResponseEntity<UserResponse> login(
            @RequestBody UserLoginRequest request
    ) {
        return ResponseEntity.ok(
                authService.login(request)
        );
    }
}
