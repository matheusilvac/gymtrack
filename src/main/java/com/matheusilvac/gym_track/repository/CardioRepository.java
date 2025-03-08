package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.cardio.Cardio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardioRepository extends JpaRepository<Cardio, UUID> {
}
