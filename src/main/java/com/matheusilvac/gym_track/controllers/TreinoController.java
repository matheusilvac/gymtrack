package com.matheusilvac.gym_track.controllers;

import com.matheusilvac.gym_track.domain.dtos.CardioDTO;
import com.matheusilvac.gym_track.domain.dtos.CardioResponse;
import com.matheusilvac.gym_track.domain.dtos.ExercicioDTO;
import com.matheusilvac.gym_track.domain.dtos.TreinoDTO;
import com.matheusilvac.gym_track.domain.entity.cardio.Cardio;
import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import com.matheusilvac.gym_track.service.TreinoService;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @PostMapping
    public ResponseEntity<Treino> criarTreinoTemporario(@RequestBody TreinoDTO treinoDTO) {
        Treino treino = treinoService.criarTreinoTemporario(treinoDTO.nome());
        return new ResponseEntity<>(treino, HttpStatus.CREATED);
    }

    // Endpoint para obter todos os treinos
    @GetMapping
    public Page<Treino> obterTodos(@PageableDefault(size = 10) Pageable paginacao) {
        return treinoService.obterTodos(paginacao);
    }


    // Endpoint para adicionar um exercício a um treino
    @PostMapping("/{treinoId}/exercicio")
    public ResponseEntity<ExercicioDTO> adicionarExercicio(@PathVariable UUID treinoId,
                                                           @RequestBody ExercicioDTO exercicioDTO) {
        Exercicio exercicio = treinoService.adicionarExercicio(treinoId, exercicioDTO);
        return new ResponseEntity<>(new ExercicioDTO(exercicio), HttpStatus.CREATED);
    }

    // Endpoint para adicionar um cardio a um treino
    @PostMapping("/{treinoId}/cardio")
    public ResponseEntity<CardioResponse> adicionarCardio(@PathVariable UUID treinoId,
                                                          @RequestBody CardioDTO cardioDTO) {
        Cardio cardio = treinoService.adicionarCardio(treinoId, cardioDTO);
        return new ResponseEntity<>(new CardioResponse(cardio), HttpStatus.CREATED);
    }

    // Endpoint para finalizar um treino
    @PutMapping("/{treinoId}/finalizar")
    public ResponseEntity<Treino> finalizarTreino(@PathVariable UUID treinoId) {
        Treino treino = treinoService.finalizarTreino(treinoId);
        return new ResponseEntity<>(treino, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TreinoDTO> remover(@PathVariable @NotNull UUID id) {
        treinoService.excluirTreino(id);
        return ResponseEntity.noContent().build();
    }
}
