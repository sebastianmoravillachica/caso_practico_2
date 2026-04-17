package com.ejerciciopractico2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    
    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(

            User.withUsername("admin@email.com")
                .password("{noop}12345")
                .roles("ADMIN")
                .build(),

            User.withUsername("org@email.com")
                .password("{noop}12345")
                .roles("ORGANIZADOR")
                .build(),

            User.withUsername("cliente@email.com")
                .password("{noop}12345")
                .roles("CLIENTE")
                .build()
        );
    }

    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth

    .requestMatchers("/login", "/error", "/css/**").permitAll()

    .requestMatchers("/usuarios/**", "/roles/**").hasRole("ADMIN")

    .requestMatchers("/eventos/**").hasAnyRole("ADMIN", "ORGANIZADOR", "CLIENTE")

    .anyRequest().authenticated()
)
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/redirect", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}