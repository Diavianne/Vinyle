package io.emiliebarre.vinyl.api.services;


import io.emiliebarre.vinyl.api.dtos.EmployeeCreate;
import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import io.emiliebarre.vinyl.api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employees;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employees = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employees.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employees.findById(id).orElse(null);
    }

    public void create(EmployeeCreate inputs) {
        Employee entity = new Employee();
        entity.setFirstname(inputs.firstname());
        entity.setLastname(inputs.lastname());
        entity.setJob(inputs.job());
        entity.setIdentifier(inputs.identifier());
        entity.setPassword(inputs.password());
        entity.setManager(inputs.manager());
        employees.save(entity);
    }

    public void updateOne(Long id, EmployeeCreate inputs) {

    }

    public void deleteOne(Long id) {
        employees.deleteById(id);
    }

    public Collection<EmployeeView> getAll() {
        return employees.findAllProjectedBy();
    }
}
