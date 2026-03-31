package com.example.apprds.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // CSRF(Cross-Site Request Forgery) 보호 기능을 비활성화
            // 개발 단계나 REST API 서버에서는 설정을 단순화하기 위해 자주 비활성화
            .csrf(csrf -> csrf.disable()) 
            // HTTP 요청에 대한 접근 권한을 설정합니다.
            .authorizeHttpRequests(auth -> auth
                // 모든 요청(.anyRequest())에 대해 인증 없이 허용(.permitAll())
                .anyRequest().permitAll() 
            );

        return http.build();
    }
}
