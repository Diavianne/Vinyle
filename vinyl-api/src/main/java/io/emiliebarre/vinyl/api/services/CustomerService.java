package io.emiliebarre.vinyl.api.services;


import io.emiliebarre.vinyl.api.dtos.CustomerCreate;
import io.emiliebarre.vinyl.api.entities.Customer;
import io.emiliebarre.vinyl.api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customers;

    public CustomerService(CustomerRepository customers) {
        this.customers = customers;
    }

    public void create(CustomerCreate inputs) {
        Customer entity = new Customer();
        entity.setName(inputs.name());
        entity.setEmail(inputs.email());
        entity.setAddress(inputs.address());
        customers.save(entity);
    }
}
