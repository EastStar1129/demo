package com.cms.demo.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
public class SecurityConfig{
    private final String URL_LOGIN = "/login";
    private final String URL_PROCESS_LOGIN = "/doLogin";
    private final String URL_LOGOUT = "/logout";
    private final String URL_DEFAULT = "/";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin((formLogin) -> formLogin.loginPage(URL_LOGIN)
                        .loginProcessingUrl(URL_PROCESS_LOGIN)
                        .failureForwardUrl(URL_LOGIN + "?failed=true")
                        .defaultSuccessUrl(URL_DEFAULT)
                )
                .logout((logout) -> logout
                        .logoutUrl(URL_LOGOUT)
                        .logoutSuccessUrl(URL_DEFAULT)
                        .invalidateHttpSession(true).deleteCookies("JSESSIONID"))
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests.requestMatchers(
                                "/admin/**"
                        ).authenticated()
                        .anyRequest().permitAll()
                )
//                .rememberMe(me -> {
//                    me.key("demo")
//                            .tokenValiditySeconds(60 * 60 * 24) // second
//                            .rememberMeParameter("rememberMe")
//                            .userDetailsService(customUserDetailsService);
//                })
                .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("X-Requested-With", "Content-Type", "Authorization", "X-XSRF-token"));
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}