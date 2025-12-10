package com.WanSoo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing
public class JpaConfig {
// 필요하면 AuditingDate 등을 설정
}