package io.emiliebarre.vinyl.api.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import io.emiliebarre.vinyl.api.entities.Employee;

import java.time.Instant;
import java.time.OffsetDateTime;


public class JWTProvider {

    private final Algorithm algorithm;
    private final String issuer;
    private final boolean hasExpiration;
    private final int expirationMinutes;

    JWTProvider(Algorithm algorithm, String issuer, boolean hasExpiration, int expirationMinutes) {
        this.algorithm = algorithm;
        this.issuer = issuer;
        this.hasExpiration = hasExpiration;
        this.expirationMinutes = expirationMinutes;
    }

    public String create(String subject) {
        Instant issuedAt = Instant.now();
        System.out.println(issuedAt);
        System.out.println(hasExpiration);

        JWTCreator.Builder builder = JWT.create()
                .withIssuedAt(issuedAt)
                .withSubject(subject)
                .withExpiresAt(OffsetDateTime.now().plusMinutes(expirationMinutes).toInstant())
                .withIssuer(issuer);
        return builder.sign(algorithm);
    }

    public String generateToken(Employee entity) {
        return create(entity.getEmail());
    }
}
