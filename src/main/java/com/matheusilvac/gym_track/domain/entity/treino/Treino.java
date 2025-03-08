package com.matheusilvac.gym_track.domain.entity.treino;

import com.matheusilvac.gym_track.domain.dtos.CardioDTO;
import com.matheusilvac.gym_track.domain.entity.cardio.Cardio;
import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import com.matheusilvac.gym_track.domain.entity.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "treinos")
@Getter
@Setter
@AllArgsConstructor
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private LocalDateTime data;

    @OneToMany(mappedBy = "treino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exercicio> exercicios;

    @ManyToOne
    @JoinColumn(name = "cardio_id")
    private Cardio cardio;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Chave estrangeira para Usuario
    private Usuario usuario;

    private boolean finalizado;

    public Treino() {
    }

    public Treino(Long id, LocalDateTime data, List<Exercicio> exercicios, CardioDTO cardio) {
    }

    public Treino(Long id, LocalDateTime data, List<Exercicio> exercicios) {
    }


}
