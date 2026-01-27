package com.example.demo.сonfig;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Отключаем CSRF
                .cors(c -> c.configurationSource(r -> new CorsConfiguration().applyPermitDefaultValues()))
                .httpBasic(AbstractHttpConfigurer::disable) // Отключаем базовую аутентификацию
                .formLogin(AbstractHttpConfigurer::disable) // Отключаем форму логина
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Все запросы разрешены
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Без сессий
                );

        return http.build();
    }
}
