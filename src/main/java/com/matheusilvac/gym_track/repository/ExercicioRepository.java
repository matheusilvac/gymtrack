package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExercicioRepository extends JpaRepository<Exercicio, UUID> {
}
