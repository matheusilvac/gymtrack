package com.matheusilvac.gym_track.domain.dtos;

import com.matheusilvac.gym_track.domain.entity.cardio.Cardio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardioResponse {
    private Double pace;
    private Integer tempo;
    private Double km;
    private String modalidadeCardio;

    public CardioResponse(Cardio cardio) {
        this.tempo = cardio.getTempo();
        this.km = cardio.getKm();
        this.modalidadeCardio = cardio.getModalidadeCardio().name();
        this.pace = cardio.getPace();
    }

    public CardioResponse() {
    }
}
