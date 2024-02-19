//package com.backend.taskmanagement.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;
//import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import java.util.Collections;
//
//@Configuration
//public class AppConfig {
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.sessionManagement(management => management.sessionCreationPolicy(
//                sessionCreationPolicy.STATELESS))
//        .authorizeHttpRequests(
//                        Authorize => Authorize.requestMatchers("/api/**").authenticated()
//                        .anyRequest().permitAll())
//        .csrf(csrf=>csrf.disabled())
//                        .cors(cors=>cors.configurationSource(CorsConfigurationSource()))
//        .formLogin(withDefaults());
//        return http.build();
//    }
//    private CorsConfigurationSource corsConfigurationSource() {
//
//        return new CorsConfigurationSource() {
//            @Override
//            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//                CorsConfiguration cfg = new CorsConfiguration();
//                cfg.setAllowedOrigins(Collections.singletonList("*"));
//                cfg.setAllowedMethods(Collections.singletonList("*"));
//                cfg.setAllowedHeaders(Collections.singletonList("*"));
//                cfg.setExposedHeaders(Collections.singletonList("*"));
//                cfg.setMaxAge(3600L);
//
//                return cfg;
//            }
//        };
//    }
//
//
//}
package com.backend.taskmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

@Configuration
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(org.springframework.security.config.http.SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers().antMatchers("/api/**").authenticated()
                                .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .formLogin(withDefaults());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
            corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
            corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
            corsConfiguration.setExposedHeaders(Collections.singletonList("*"));
            corsConfiguration.setMaxAge(3600L);

            return corsConfiguration;
        };
    }
}

