package com.WanSoo.service;

import com.WanSoo.entity.user.User;
import com.WanSoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 🔐 Spring Security 인증용
     */
    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        log.info("[SECURITY] loadUserByUsername email={}", email);

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                "해당 이메일의 사용자를 찾을 수 없습니다. email=" + email
                        ));
    }

    /**
     * 📌 사용자 단건 조회
     */
    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "사용자를 찾을 수 없습니다. email=" + email
                        ));
    }

    /**
     * 📌 사용자 저장 (AuthService 내부에서 사용)
     */
    @Transactional
    public User save(User user) {
        log.info("[USER] save email={}", user.getEmail());
        return userRepository.save(user);
    }

    /**
     * 📌 이메일 중복 여부 확인
     */
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
