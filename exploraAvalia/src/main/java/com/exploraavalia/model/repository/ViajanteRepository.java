package com.exploraavalia.model.repository;

import com.exploraavalia.model.entity.Viajante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ViajanteRepository extends JpaRepository<Viajante, Long> {
    Optional<Viajante> findByEmail(String email);
}
