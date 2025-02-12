package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}
