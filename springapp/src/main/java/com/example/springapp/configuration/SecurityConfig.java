package com.example.springapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security configuration for the application.
 * 
 * @author PAVAN SUNDAR PENDEM 10828911
 *         Annotated with `@Configuration` to indicate a Spring configuration
 *         class.
 *         `@EnableWebSecurity` to enable web security features.
 *         `@EnableMethodSecurity` to enable method-level security annotations.
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    /**
     * Configures the Spring Security filter chain.
     *
     * @param http the `HttpSecurity` object used to customize security settings.
     *             - Disables CSRF and CORS protections.
     *             - Configures public access to specific API endpoints
     *             (`permitAll`).
     *             - Ensures authentication is required for all other endpoints.
     * @return the configured `SecurityFilterChain` object.
     * @throws Exception if there is an issue configuring the security chain.
     */
    @Autowired
    CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("*",
                                "/api/test/welcome",
                                "/api/test/team",
                                "/api/team",
                                "/api/team/{teamId}",
                                "/api/player",
                                "/api/player/{playerId}",
                                "/api/organizer/assign-player",
                                "/api/organizer/unsold-players",
                                "/api/organizer/sold-players",
                                "/api/organizer/release-player",
                                "/api/organizer/team",
                                "/api/organizer/team/{teamId}/players",
                                "/api/organizer/release-player/{playerId}",
                                "/api/organizer/players-list",
                                "/api/user/register",
                                "/api/user/login",
                                "/api/user",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html/",
                                "/webjars/**")
                        .permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}