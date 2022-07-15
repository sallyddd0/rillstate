package com.baekhwa.song.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
	
	
	private final CustomOAuth2UserService customOAuth2UserService;
	//private final CustomAuthenticationFailureHandler failureHandler;
	//private final CustomAuthenticationSuccessHandler successHandler;
	//DaoAuthenticationProvider
	//AuthenticationSuccessHandler

    
    
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize ->
                        authorize
                        		.antMatchers("/css/**","/js/**","/images/**", "/favicon.ico*").permitAll()
                                .antMatchers("/", "/common/**","/request-key/*").permitAll()
                                .antMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                );
        
        http.oauth2Login(oauth2Login->
        		oauth2Login
        			.loginPage("/signin")
        			//.defaultSuccessUrl("/")
        			.userInfoEndpoint()
        				.userService(customOAuth2UserService))
        			;
        
        //http.formLogin();
        //*
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/signin")
                        .usernameParameter("email")//Defaultis "username".
                        .passwordParameter("pass")//Defaultis "password".
                        .failureUrl("/signin?errMsg")
                        .loginProcessingUrl("/signin")//login-form action post url-별도로 구현하지 않아요
                        .defaultSuccessUrl("/")
                        //.successHandler(successHandler())
                        //.failureHandler(failureHandler())//로그인실패시 처리
                        .permitAll()
        );
        //*/

        http.logout(logout -> logout
        		.logoutSuccessUrl("/")
        		.invalidateHttpSession(true)
        		);//default is "/login?logout".
        
        http.csrf();

        return http.build();
    }
	
	
}
