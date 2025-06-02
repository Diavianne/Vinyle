package io.emiliebarre.vinyl.api.controllers;

import io.emiliebarre.vinyl.api.dtos.EmployeeAuthenticateService;
import io.emiliebarre.vinyl.api.dtos.EmployeeCreate;
import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import io.emiliebarre.vinyl.api.services.EmployeeService;
import io.emiliebarre.vinyl.api.dtos.Authentication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    public final EmployeeService employeeService;
    public final EmployeeAuthenticateService authService;


    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeAuthenticateService authService) {
        this.employeeService = employeeService;
        this.authService = authService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody @Valid EmployeeCreate inputs) {
        employeeService.create(inputs);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String authenticate(@RequestBody Authentication inputs) {
        return authService.authenticate(inputs);
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
