package com.matheusilvac.gym_track.domain.entity.exercicio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheusilvac.gym_track.domain.entity.series.Series;
import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "exercicios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nomeExercicio;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    @JsonIgnore
    private Treino treino;

    @OneToMany(mappedBy = "exercicio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Series> series;

}
