package io.emiliebarre.vinyl.api.dtos;


import io.emiliebarre.vinyl.api.config.JWTProvider;
import io.emiliebarre.vinyl.api.entities.Employee;
import io.emiliebarre.vinyl.api.repositories.EmployeeRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeAuthenticateService {
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTProvider jwtProvider;

    public EmployeeAuthenticateService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder, JWTProvider jwtProvider) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public String authenticate(Authentication inputs) {
        String email = inputs.email();
        // Verify if email exists in DB
        Employee entity = employeeRepository.findAllByEmailIgnoreCase(email)
                .orElseThrow(() -> new BadCredentialsException("Invalid email or password"));

        // Verify the pair of email and password
        boolean compared = passwordEncoder.matches(inputs.password(), entity.getPassword());
        if (compared) {
            // Generate JWT token
            String token = jwtProvider.generateToken(entity);
            // Here you can return the token or handle it as needed
            System.out.println("Authentication successful, token: " + token);
            return jwtProvider.generateToken(entity);
        } else {
            throw new BadCredentialsException("Invalid email or password");
        }
    }
}
