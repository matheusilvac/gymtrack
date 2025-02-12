package com.matheusilvac.gym_track.domain.dtos;

import com.matheusilvac.gym_track.domain.enums.modalidadeCardio.ModalidadeCardio;

public record CardioDTO(
        Integer tempo,
        Double km,
        Double pace,
        ModalidadeCardio modalidadeCardio
) {
}
