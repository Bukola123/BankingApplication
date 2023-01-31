package com.bankApp.authentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webSecurity {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors().and().csrf().disable()
                .headers()
                .httpStrictTransportSecurity().includeSubDomains(true)
                .maxAgeInSeconds(31536000)
                .and().xssProtection()
                .and().contentSecurityPolicy("'default-src \\'self\\'; img-src https://*; child-src \\'none\\''")
                .and().frameOptions().sameOrigin()
                .and().authorizeRequests()
                .anyRequest()
                .permitAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }


    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
