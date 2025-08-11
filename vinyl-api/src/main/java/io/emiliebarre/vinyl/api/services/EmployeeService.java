package io.emiliebarre.vinyl.api.services;


import io.emiliebarre.vinyl.api.dtos.EmployeeCreate;
import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import io.emiliebarre.vinyl.api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository repos;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeService(EmployeeRepository repos, PasswordEncoder passwordEncoder) {
        this.repos = repos;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Employee> getAllEmployees() {
        return repos.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repos.findById(id).orElse(null);
    }

    @Transactional
    public void create(EmployeeCreate inputs) {
        if (repos.existsByEmail(inputs.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email déjà utilisée");
        }
        Employee entity = new Employee();
        entity.setFirstname(inputs.firstname());
        entity.setLastname(inputs.lastname());
        entity.setEmail(inputs.email());
        entity.setPassword(passwordEncoder.encode(inputs.password()));
        repos.save(entity);
    }

    public void updateOne(Long id, EmployeeCreate inputs) {

    }

    public void deleteOne(Long id) {
        repos.deleteById(id);
    }

    public Collection<EmployeeView> getAll() {
        return repos.findAllProjectedBy();
    }
}
