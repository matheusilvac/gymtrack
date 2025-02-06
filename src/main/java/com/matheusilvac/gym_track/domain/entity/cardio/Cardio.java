package com.matheusilvac.gym_track.domain.entity.cardio;

import com.matheusilvac.gym_track.domain.enums.modalidadeCardio.ModalidadeCardio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cardio")
@NoArgsConstructor
@AllArgsConstructor
public class Cardio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tempo;

    private Double km;

    private Double pace;

    @Enumerated(EnumType.STRING)
    private ModalidadeCardio modalidadeCardio;
}
