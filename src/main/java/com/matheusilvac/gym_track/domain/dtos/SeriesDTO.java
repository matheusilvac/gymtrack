package com.matheusilvac.gym_track.domain.dtos;


import com.matheusilvac.gym_track.domain.entity.series.Series;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeriesDTO {
    private Integer repeticao;
    private Integer carga;
    private String tipoSerieEnum;

    public SeriesDTO(Series series) {
        this.tipoSerieEnum = series.getTipoSerieEnum().toString();
        this.repeticao = series.getRepeticao();
        this.carga = series.getCarga();
    }

    public SeriesDTO() {
    }
}
