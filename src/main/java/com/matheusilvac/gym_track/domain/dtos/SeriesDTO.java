package com.matheusilvac.gym_track.domain.dtos;

import com.matheusilvac.gym_track.domain.enums.tipoSerieEnum.TipoSerieEnum;

public record SeriesDTO(
        Integer repeticao,
        Integer carga,
        String tipoSerieEnum
) {
}
