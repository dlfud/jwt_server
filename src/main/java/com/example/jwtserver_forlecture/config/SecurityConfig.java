package com.example.jwtserver_forlecture.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{


    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션을 사용하지 않음
                .and()
                .formLogin().disable()// jwt 인증방식을 위해 id pw를 폼로그인으로 처리를 안함
                .httpBasic().disable()// http 기본 인증방식을 사용안함
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/api/v1/user/**")
                        .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("/api/v1/manager/**")
                        .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("/api/v1/admin/**")
                        .access("hasRole('ROLE_ADMIN')")
                        .anyRequest().permitAll()
                )
                .build();
    }
}
