package io.emiliebarre.vinyl.api.repositories;

import io.emiliebarre.vinyl.api.dtos.CustomerView;
import io.emiliebarre.vinyl.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Collection<CustomerView> findAllProjectedBy();

    List<CustomerView> findByEmailContainingIgnoreCase(String email);
}
