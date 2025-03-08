package com.matheusilvac.gym_track.domain.entity.series;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import com.matheusilvac.gym_track.domain.enums.tipoSerieEnum.TipoSerieEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@Table(name = "series")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoSerieEnum tipoSerieEnum;

    private Integer repeticao;
    private Integer carga;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    @JsonIgnore
    private Exercicio exercicio;

}
