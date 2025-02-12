package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
