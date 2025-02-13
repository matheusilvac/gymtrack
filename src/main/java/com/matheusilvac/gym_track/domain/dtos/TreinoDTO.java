package com.matheusilvac.gym_track.domain.dtos;


import java.time.LocalDateTime;
import java.util.List;

public record TreinoDTO(
        LocalDateTime data,
        String nome,
        List<ExercicioDTO> exercicios,
        CardioDTO cardio
) {

}
