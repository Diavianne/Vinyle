package io.emiliebarre.vinyl.api.repositories;

import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<EmployeeView> findAllProjectedBy();

    Optional<Employee> findAllByEmailIgnoreCase(String email);
}
