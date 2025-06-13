package io.emiliebarre.vinyl.api.repositories;


import io.emiliebarre.vinyl.api.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;


@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findByCustomerEmailAndStatus(String email, String status);
}
