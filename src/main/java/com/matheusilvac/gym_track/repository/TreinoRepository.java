package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreinoRepository extends JpaRepository<Treino, UUID> {
    Page<Treino> findAllByOrderByDataAsc(Pageable paginacao);
}
