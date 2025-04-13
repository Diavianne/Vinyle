package io.emiliebarre.vinyl.api.services;


import io.emiliebarre.vinyl.api.dtos.EmployeeCreate;
import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import io.emiliebarre.vinyl.api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository repos;

    @Autowired
    public EmployeeService(EmployeeRepository repos) {
        this.repos = repos;
    }

    public List<Employee> getAllEmployees() {
        return repos.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repos.findById(id).orElse(null);
    }

    @Transactional
    public void create(EmployeeCreate inputs) {
        Employee entity = new Employee();
        entity.setFirstname(inputs.firstname());
        entity.setLastname(inputs.lastname());
        entity.setPassword(inputs.password());
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
