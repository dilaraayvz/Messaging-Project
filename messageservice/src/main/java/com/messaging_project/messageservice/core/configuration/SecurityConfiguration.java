package com.messaging_project.messageservice.core.configuration;

import com.messaging.security.BaseJwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final BaseJwtFilter baseJwtFilter;
    private static final String[] WHITE_LIST = {
            "/swagger-ui/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrfConfigurer -> csrfConfigurer.disable()) // CSRF korumasını devre dışı bırakır
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(WHITE_LIST).permitAll() // WHITE_LIST içinde tanımlanan yollar için izin veriliyor
                                .anyRequest().authenticated() // Diğer tüm istekler için kimlik doğrulaması gerektir
                )
                .sessionManagement(sessionManagementConfigurer ->
                        sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Oturum yaratma politikasını STATELESS yapar
                )
                .addFilterBefore(baseJwtFilter, UsernamePasswordAuthenticationFilter.class) // JwtFilter'ı SecurityFilterChain'e ekler
                .httpBasic(httpBasicConfigurer -> httpBasicConfigurer.disable()); // HTTP Basic Authentication'ı devre dışı bırakır

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}