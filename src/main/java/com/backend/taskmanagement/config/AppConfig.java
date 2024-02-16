package com.backend.taskmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return null;
    }
}
