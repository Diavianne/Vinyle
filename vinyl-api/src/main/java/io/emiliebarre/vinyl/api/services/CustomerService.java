package io.emiliebarre.vinyl.api.services;


import io.emiliebarre.vinyl.api.dtos.CustomerCreate;
import io.emiliebarre.vinyl.api.dtos.CustomerUpdate;
import io.emiliebarre.vinyl.api.dtos.CustomerView;
import io.emiliebarre.vinyl.api.entities.Customer;
import io.emiliebarre.vinyl.api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    public Collection<CustomerView> getAll() {
        return customers.findAllProjectedBy();
    }

    public Collection<CustomerView> searchByEmail(String email) {
        return customers.findByEmailContainingIgnoreCase(email);
    }

    public Customer getCustomerById(Long id) {
        return customers.findById(id).orElse(null);
    }

    public void updateOne(Long id, CustomerUpdate inputs) {
        Customer entity = customers.findById(id).orElse(null);
        entity.setName(inputs.name());
        entity.setEmail(inputs.email());
        entity.setAddress(inputs.address());
        customers.save(entity);

    }

    public void deleteOne(Long id) {
        customers.deleteById(id);
    }
}
