package io.emiliebarre.vinyl.api.repositories;

import io.emiliebarre.vinyl.api.dtos.EmployeeView;
import io.emiliebarre.vinyl.api.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Collection<EmployeeView> findAllProjectedBy();
}
