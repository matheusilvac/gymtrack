package com.matheusilvac.gym_track.domain.dtos;

import java.util.List;

public record ExercicioDTO(String nome, List<SeriesDTO> series ) {
}
