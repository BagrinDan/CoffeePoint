package com.example.demo.config;


import com.example.demo.security.JwtCookieFilter;
import com.example.demo.security.JwtCore;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtCore jwtCore;
    private final UserDetailsService userDetailsService;

    @Bean
    public JwtCookieFilter jwtCookieFilter() {
        return new JwtCookieFilter(jwtCore, userDetailsService);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                //.cors(c -> c.configurationSource(r -> new CorsConfiguration().applyPermitDefaultValues())) если нужно выключить cors
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(List.of("http://localhost:5173"));
                    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    corsConfiguration.setAllowedHeaders(List.of("*"));
                    corsConfiguration.setAllowCredentials(true);
                    return corsConfiguration;
                }))
                .exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(a -> a
                        .requestMatchers("/",
                                "/public/**",

                                "/api/auth/signin",
                                "/api/login",

                                "/api/auth/signup",
                                "/api/register/",

                                "/swagger-ui",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**").
                        permitAll()

                        .requestMatchers(
                                "/private/**"
                        ).authenticated() // Тут только ЮЗЕРАМ
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Тут только АДМИНАМ

                        .anyRequest().authenticated()


                )

                .logout(logout -> logout
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessUrl("/") // Указываем редирект на главную после выхода
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID", "jwt-token") // Убедитесь, что имя куки совпадает с вашим (token или JWT_TOKEN)
                )


                .addFilterBefore(jwtCookieFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
