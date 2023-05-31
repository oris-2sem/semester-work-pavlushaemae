package com.example.dragi.config;

import com.example.dragi.services.impl.CustomUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{

    private final CustomUserDetailsServiceImpl customUserDetailsService;

    AuthenticationManager authenticationManager;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailsService);
        authenticationManager = authenticationManagerBuilder.build();

        httpSecurity
                .csrf().ignoringAntMatchers("/reviews*/**")
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**")
                .hasAuthority("ROLE_ADMIN")
                .antMatchers("/product/create", "/product/edit/**", "/product/delete*/**,", "/product/my-products" )
                .hasAuthority("ROLE_SELLER")
                .antMatchers("/basket/**", "/product/**", "/profile/**")
                .authenticated()
                .antMatchers("/","/images/**", "/registration","/reviews/**")
                .permitAll()
                .anyRequest().permitAll()
                .and()
                .authenticationManager(authenticationManager)
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }
}
