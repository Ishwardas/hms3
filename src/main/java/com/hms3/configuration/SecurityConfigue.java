package com.hms3.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfigue {

    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity
    )throws Exception
    {
     httpSecurity.csrf().disable().cors().disable();
     httpSecurity.authorizeHttpRequests().anyRequest().permitAll();
     return httpSecurity.build();
    }
}
