package io.emiliebarre.vinyl.api.controllers;


import io.emiliebarre.vinyl.api.dtos.CustomerCreate;
import io.emiliebarre.vinyl.api.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    void create(@Valid @RequestBody CustomerCreate inputs) {
        customerService.create(inputs);
    }
}
