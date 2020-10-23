package com.documents.demo.config;

import com.documents.demo.service.UserService;
import com.documents.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//config class

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

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
                .mvcMatchers("/api/v1/registration").permitAll()
                //for non authorized users
                .mvcMatchers("/api/v1/registration").permitAll()
                .mvcMatchers("/swagger-ui").permitAll()
                .mvcMatchers("/h2-console").permitAll()
                //only for admins
                .mvcMatchers("/api/v1/admin/**").hasRole("ADMIN")
                //only for users
                .mvcMatchers("/api/v1/document/**").hasAnyRole("USER", "ADMIN")
            //other pages need authenticate
//            .anyRequest().authenticated()//permitAll()
            .and().httpBasic()
            .and()
                .formLogin()
//                .loginPage("/login")
                //success when login
                .successForwardUrl("/")
                .permitAll()
            .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
