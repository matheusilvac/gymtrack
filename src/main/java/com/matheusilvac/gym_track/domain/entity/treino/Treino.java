package com.matheusilvac.gym_track.domain.entity.treino;

import com.matheusilvac.gym_track.domain.dtos.CardioDTO;
import com.matheusilvac.gym_track.domain.entity.cardio.Cardio;
import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "treinos")
@Getter
@Setter
@AllArgsConstructor
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDateTime data;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercicio> exercicios;

    @ManyToOne
    @JoinColumn(name = "cardio_id")
    private Cardio cardio;

    private boolean finalizado;

    public Treino() {
    }

    public Treino(Long id, LocalDateTime data, List<Exercicio> exercicios, CardioDTO cardio) {
    }

    public Treino(Long id, LocalDateTime data, List<Exercicio> exercicios) {
    }


}
