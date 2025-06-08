package io.emiliebarre.vinyl.api.repositories;

import io.emiliebarre.vinyl.api.dtos.CustomerView;
import io.emiliebarre.vinyl.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);

    List<CustomerView> findAllProjectedBy();

    List<CustomerView> findByEmailContainingIgnoreCase(String email);

}
