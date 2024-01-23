package com.nexon.maple.config.security;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
*/
//@EnableWebSecurity
//@EnableWebMvc
public class SecurityConfig{
    /*
    private final String URL_LOGOUT = "/logout";
    private final String URL_INDEX = "/index";
    private final String URL_DEFAULT = "/";

    public SecurityConfig() {}
    @Bean
    @Order(0)

    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/resources/js/**", "/resources/css/**", "/resources/image/**",
                        "/favicon.ico", URL_DEFAULT, URL_INDEX);
    }

    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.cors(AbstractHttpConfigurer::disable)
            .csrf(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .sessionManagement((sessionManagement) -> sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .logout((logout) -> logout
                    .logoutUrl(URL_LOGOUT)
                    .logoutSuccessUrl(URL_DEFAULT)
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID"))
            .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                    .anyRequest().authenticated()
            );
        return http.build();
    }
    */
}