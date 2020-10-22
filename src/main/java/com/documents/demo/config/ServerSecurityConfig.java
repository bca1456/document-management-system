package com.documents.demo.config;

import com.documents.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//config class

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    /*For encode pass*/
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .headers().frameOptions().disable() //need for showing h2db in browser (clickjaking)
                .and()
            .cors()
                .and()
            .csrf().disable() //for disable fake query
            .authorizeRequests()
                //for non authorized users
                .antMatchers("/api/v1/registration").permitAll()
                .antMatchers("/swagger-ui").permitAll()
                .antMatchers("/h2-console").permitAll()
                //only for admins
                .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
                //only for users
                .antMatchers("/api/v1/document").hasRole("USER")
            //other pages need authenticate
            .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                //success when login
                .successForwardUrl("/")
                .permitAll()
            .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    /*@Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }*/
}
