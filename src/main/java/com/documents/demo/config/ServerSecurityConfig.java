package com.documents.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//config class

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers().frameOptions().disable() //need for showing h2db in browser (clickjaking)
                .and()
            .cors()
                .and()
            .csrf().disable() //for disable fake query
            .authorizeRequests()
                .anyRequest().permitAll()
        ;
    }
}
