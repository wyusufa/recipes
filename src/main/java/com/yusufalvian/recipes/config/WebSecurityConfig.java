package com.yusufalvian.recipes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .antMatchers("/api/recipe/**").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/register").permitAll()
                .antMatchers("/**").permitAll();

        http.csrf()
                .disable();
        http.headers()
                .frameOptions()
                .disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
