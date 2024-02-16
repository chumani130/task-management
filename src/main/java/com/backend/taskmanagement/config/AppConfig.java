package com.backend.taskmanagement.config;

import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class AppConfig {
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.sessionManagement(management => management.sessionCreationPolicy(
                sessionCreationPolicy.STATELESS)).authorizeHttprequests(
                        // endpoints that should be protected
                        Authorize => Authorize.requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()).csrf(csrf=>csrf.disabled())
                        .cors(cors=>cors.configurationSource(CorsConfigurationSource()))
                        .httpBasic(WithDefaults())
                        .formLogin(WithDefaults());
        return null;
    }

   
}
