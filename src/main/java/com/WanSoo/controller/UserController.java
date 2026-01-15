package com.WanSoo.controller;

import com.WanSoo.dto.user.UserResponse;
import com.WanSoo.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    /**
     * 👤 내 정보 조회
     */
    @GetMapping("/me")
    public ResponseEntity<UserResponse> myInfo(
            @AuthenticationPrincipal User user
    ) {
        return ResponseEntity.ok(UserResponse.from(user));
    }
}
