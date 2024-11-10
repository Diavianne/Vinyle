package io.emiliebarre.vinyl.api.repositories;

import io.emiliebarre.vinyl.api.entities.Vinyl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinylRepository extends JpaRepository<Vinyl, Long> {
}
