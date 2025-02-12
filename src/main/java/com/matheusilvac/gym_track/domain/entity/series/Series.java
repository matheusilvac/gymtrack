package com.matheusilvac.gym_track.domain.entity.series;

import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import com.matheusilvac.gym_track.domain.enums.tipoSerieEnum.TipoSerieEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "series")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Series {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoSerieEnum tipoSerieEnum;

    private Integer repeticao;
    private Integer carga;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

}
