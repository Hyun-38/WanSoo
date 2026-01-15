package com.WanSoo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequest {

    /**
     * 로그인 이메일
     */
    @Email
    @NotBlank
    private String email;

    /**
     * 평문 비밀번호 (요청용)
     * → Service에서 암호화 비교
     */
    @NotBlank
    private String password;
}
