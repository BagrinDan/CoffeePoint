package com.example.demo.config;


import com.example.demo.middleware.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtCookieFilter;
import com.example.demo.security.JwtCore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;




@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtCore jwtCore;
    private final UserDetailsService userDetailsService;

    // Middleware
    private final JwtAuthenticationEntryPoint authenticationHandler;

    // Beans
    @Bean
    public JwtCookieFilter jwtCookieFilter() {
        return new JwtCookieFilter(jwtCore, userDetailsService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)

                // --- Cors off ---
                .cors(c -> c.configurationSource(r -> new CorsConfiguration().applyPermitDefaultValues())) // если нужно выключить cors

                // --- Cors on ---
                /*.cors(cors -> cors.configurationSource(request -> {
                    var corsConfiguration = new CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(List.of("http://localhost:5173"));
                    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
                    corsConfiguration.setAllowedHeaders(List.of("*"));
                    corsConfiguration.setAllowCredentials(true);
                    return corsConfiguration;
                }))*/

                // -- Middleware --
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(authenticationHandler)
                )

                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // -- Auth --
                .authorizeHttpRequests(a -> a
                        // --- Public stuff ---
                        .requestMatchers("/",
                                "/public/**",

                                "/api/auth/signin",
                                "/api/login",

                                "/api/auth/signup",
                                "/api/register/",

                                "/error",
                                "/swagger-ui",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/v3/api-docs/**").
                        permitAll() // Публиные

                        // --- Users ---
                        .requestMatchers(
                                "/private/**"
                        ).authenticated()

                        // --- Admin ---
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Тут только АДМИНАМ
                        .anyRequest().authenticated()
                )

                .logout(logout -> logout
                        .logoutUrl("/public/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID", "jwt-token")
                )

                .addFilterBefore(jwtCookieFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
