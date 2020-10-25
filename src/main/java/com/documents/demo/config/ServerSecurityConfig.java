package com.documents.demo.config;

import com.documents.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//config class

@Configuration
@EnableWebSecurity
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userService;

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
                .antMatchers("/api/v1/registration/**").permitAll()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                //only for admins
                .antMatchers("/api/v1/admin/**").hasRole("ADMIN")
                //only for users/admins
                .antMatchers("/api/v1/document/**").hasAnyRole("USER", "ADMIN")
            //other pages need authenticate
            .anyRequest().authenticated()//permitAll()
            .and()
                .formLogin()
                    .loginPage("/login")
                    //success when login
                    .successForwardUrl("/")
                    .permitAll()
            .and()
                .logout()
                    .permitAll()
                    .logoutSuccessUrl("/")
            .and().httpBasic();
    }

    /*For encode pass*/
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider())
            .userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }*/

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }
}
