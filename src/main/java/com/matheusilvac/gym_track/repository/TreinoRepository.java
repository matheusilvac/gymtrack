package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
    Optional<Treino> findAllByOrderByDataAsc();
}
