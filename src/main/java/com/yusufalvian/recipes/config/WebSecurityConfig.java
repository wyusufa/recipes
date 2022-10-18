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
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .mvcMatchers(HttpMethod.POST,"/api/register").permitAll()
                .mvcMatchers(HttpMethod.POST,"/api/recipe/new").hasRole("USER")
                .mvcMatchers(HttpMethod.GET,"/api/recipe/search/**").hasRole("USER")
                .mvcMatchers(HttpMethod.GET,"/api/recipe/**").hasRole("USER")
                .mvcMatchers(HttpMethod.PUT,"/api/recipe/**").hasRole("USER")
                .mvcMatchers(HttpMethod.DELETE,"/api/recipe/**").hasRole("USER");

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
