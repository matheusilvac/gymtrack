package com.matheusilvac.gym_track.domain.entity.cardio;

import com.matheusilvac.gym_track.domain.dtos.CardioDTO;
import com.matheusilvac.gym_track.domain.enums.modalidadeCardio.ModalidadeCardio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "cardio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cardio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Integer tempo;

    private Double km;

    private Double pace;

    @Enumerated(EnumType.STRING)
    private ModalidadeCardio modalidadeCardio;


    public Cardio(CardioDTO cardioDTO) {
        this.tempo = cardioDTO.getTempo();
        this.km = cardioDTO.getKm();
        this.modalidadeCardio = ModalidadeCardio.valueOf(cardioDTO.getModalidadeCardio());
    }

}
