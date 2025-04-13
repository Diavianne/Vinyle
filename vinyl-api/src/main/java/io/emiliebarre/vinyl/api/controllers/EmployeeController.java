package io.emiliebarre.vinyl.api.controllers;

import io.emiliebarre.vinyl.api.dtos.EmployeeCreate;
import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import io.emiliebarre.vinyl.api.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    void create(@Valid @RequestBody EmployeeCreate inputs) {
        employeeService.create(inputs);
    }

    @GetMapping
    Collection<EmployeeView> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    void updateOne(@PathVariable("id") Long id,
                   @ModelAttribute EmployeeCreate inputs) {
        employeeService.updateOne(id, inputs);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable("id") Long id) {
        employeeService.deleteOne(id);
    }
}
