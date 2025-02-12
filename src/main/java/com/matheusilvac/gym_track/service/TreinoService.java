package com.matheusilvac.gym_track.service;

import com.matheusilvac.gym_track.domain.dtos.ExercicioDTO;
import com.matheusilvac.gym_track.domain.dtos.SeriesDTO;
import com.matheusilvac.gym_track.domain.dtos.TreinoDTO;
import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import com.matheusilvac.gym_track.domain.entity.series.Series;
import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import com.matheusilvac.gym_track.domain.enums.tipoSerieEnum.TipoSerieEnum;
import com.matheusilvac.gym_track.repository.ExercicioRepository;
import com.matheusilvac.gym_track.repository.SeriesRepository;
import com.matheusilvac.gym_track.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    // Criar treino temporário
    public Treino criarTreinoTemporario(String nome) {
        // Criar um treino temporário (não finalizado)
        Treino treino = new Treino();
        treino.setData(LocalDateTime.now());  // Data de criação do treino
        treino.setFinalizado(false);  // O treino ainda está em progresso
        treinoRepository.save(treino);
        return treino;
    }

    public List<Treino> obterTodos(){
        return treinoRepository.findAllByOrderByDataAsc()
                .stream()
                .map(treino -> new Treino(treino.getId(), treino.getData(), treino.getExercicios(), treino.getCardio()))
                .collect(Collectors.toList());
    }

    // Adicionar exercício ao treino
    public Exercicio adicionarExercicio(Long treinoId, ExercicioDTO exercicioDTO) {
        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        if (treino.isFinalizado()) {
            throw new RuntimeException("Não é possível adicionar exercício a um treino finalizado.");
        }

        Exercicio exercicio = new Exercicio();
        exercicio.setNome(exercicioDTO.nome());
        exercicio.setTreino(treino);
        exercicioRepository.save(exercicio);

        // Adicionando as séries
        for (SeriesDTO seriesDTO : exercicioDTO.series()) {
            Series series = new Series();
            series.setTipoSerieEnum(TipoSerieEnum.valueOf(seriesDTO.tipoSerieEnum()));
            series.setRepeticao(seriesDTO.repeticao());
            series.setCarga(seriesDTO.carga());
            series.setExercicio(exercicio);
            seriesRepository.save(series);
        }

        return exercicio;
    }

    // Finalizar treino
    public Treino finalizarTreino(Long treinoId) {
        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        if (treino.isFinalizado()) {
            throw new RuntimeException("Treino já está finalizado.");
        }

        treino.setFinalizado(true);
        treinoRepository.save(treino);
        return treino;
    }
}
