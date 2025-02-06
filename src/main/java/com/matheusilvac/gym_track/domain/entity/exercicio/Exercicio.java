package com.matheusilvac.gym_track.domain.entity.exercicio;

import com.matheusilvac.gym_track.domain.entity.series.Series;
import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "exercicios")
@NoArgsConstructor
@AllArgsConstructor
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    @OneToMany(mappedBy = "exercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Series> series;
}
