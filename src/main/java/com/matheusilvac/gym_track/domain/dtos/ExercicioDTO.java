package com.matheusilvac.gym_track.domain.dtos;

import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ExercicioDTO {
    private String nomeExercicio;
    private List<SeriesDTO> series;

    public ExercicioDTO(Exercicio exercicio) {
        this.nomeExercicio = exercicio.getNomeExercicio();
        this.series = (exercicio.getSeries() != null) ?
                exercicio.getSeries().stream()
                        .map(SeriesDTO::new)
                        .collect(Collectors.toList())
                : List.of();
    }

    public ExercicioDTO() {
    }
}
