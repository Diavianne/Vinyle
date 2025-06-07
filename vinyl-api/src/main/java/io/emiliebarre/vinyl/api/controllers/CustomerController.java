package io.emiliebarre.vinyl.api.controllers;


import io.emiliebarre.vinyl.api.dtos.CustomerCreate;
import io.emiliebarre.vinyl.api.dtos.CustomerUpdate;
import io.emiliebarre.vinyl.api.dtos.CustomerView;
import io.emiliebarre.vinyl.api.entities.Customer;
import io.emiliebarre.vinyl.api.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    void create(@Valid @ModelAttribute CustomerCreate inputs) {
        customerService.create(inputs);
    }

    @GetMapping
    Collection<CustomerView> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    void updateOne(@PathVariable("id") Long id,
                   @Valid @ModelAttribute CustomerUpdate inputs) {
        customerService.updateOne(id, inputs);
    }

    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable("id") Long id) {
        customerService.deleteOne(id);
    }
}
