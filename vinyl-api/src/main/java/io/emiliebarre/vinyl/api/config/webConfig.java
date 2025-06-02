package io.emiliebarre.vinyl.api.config;


import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration

public class webConfig {

    @Value("${io.emiliebarre.vinyl.api.toursBcrypt}")
    private int tours;

    @Value("${io.emiliebarre.vinyl.api.jwt.secret}")
    private String secret;

    @Value("${io.emiliebarre.vinyl.api.issuer}")
    private String issuer;

    @Value("${io.emiliebarre.vinyl.api.jwt.expirationMinutes}")
    private int expirationMinutes;

    @Value("${io.emiliebarre.vinyl.api.jwt.hasExpiration}")
    private boolean hasExpiration;


    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Value("${io.emiliebarre.vinyl.api.cors}")
            private String origins;

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("POST", "GET", "PATCH", "PUT", "DELETE")
                        .allowedOrigins(origins);
            }
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(tours);
    }

    @Bean
    public JWTProvider jwtProvider() {
        com.auth0.jwt.algorithms.Algorithm algo = com.auth0.jwt.algorithms.Algorithm.HMAC256(secret);
        return new JWTProvider(algo, issuer, hasExpiration, expirationMinutes);
    }

    @Bean
    JwtDecoder jwtDecoder() {
        SecretKey secretKey = new SecretKeySpec(secret.getBytes(),
                "HMACSHA256");

        OAuth2TokenValidator<Jwt> validators = JwtValidators.createDefaultWithIssuer(issuer);

        NimbusJwtDecoder decoder = NimbusJwtDecoder.withSecretKey(secretKey)
                .macAlgorithm(MacAlgorithm.HS256)
                .build();
        decoder.setJwtValidator(validators);

        return decoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/employees", "/employees/authenticate").permitAll()
                        .requestMatchers(HttpMethod.GET, "/vinyls").permitAll()
                        .requestMatchers(HttpMethod.GET, "/customers").permitAll()
                        .requestMatchers(HttpMethod.GET, "/employees").permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))
                .build();
    }
}
