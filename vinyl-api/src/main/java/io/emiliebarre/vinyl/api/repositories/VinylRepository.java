package io.emiliebarre.vinyl.api.repositories;

import io.emiliebarre.vinyl.api.dtos.VinylView;
import io.emiliebarre.vinyl.api.entities.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VinylRepository extends JpaRepository<Vinyl, Long> {
    Collection<VinylView> findAllProjectedBy();
}
