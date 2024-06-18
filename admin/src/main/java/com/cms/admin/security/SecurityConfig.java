package com.cms.admin.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig{
    private final String URL_LOGIN = "/admin/login";
    private final String URL_PROCESS_LOGIN = "/admin/doLogin";
    private final String URL_LOGOUT = "/admin/logout";
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
//                .sessionManagement((sessionManagement) -> sessionManagement
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin((formLogin) -> formLogin.loginPage(URL_LOGIN)
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .loginProcessingUrl(URL_PROCESS_LOGIN)
                        .failureUrl(URL_LOGIN + "?failed=true")
                        .successHandler(customAuthenticationSuccessHandler)
                )
                .logout((logout) -> logout
                        .logoutUrl(URL_LOGOUT)
                        .logoutSuccessUrl(URL_LOGIN)
                        .invalidateHttpSession(true).deleteCookies("JSESSIONID"))
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests.requestMatchers("/admin/js/**", "/admin/css/**", URL_LOGIN, URL_PROCESS_LOGIN).permitAll()
                        .anyRequest().authenticated()
                )
                .build();
    }

    // CORS 설정 메소드 예시
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}