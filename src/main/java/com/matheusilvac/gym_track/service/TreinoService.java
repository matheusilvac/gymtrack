package com.matheusilvac.gym_track.service;

import com.matheusilvac.gym_track.domain.dtos.CardioDTO;
import com.matheusilvac.gym_track.domain.dtos.ExercicioDTO;
import com.matheusilvac.gym_track.domain.dtos.SeriesDTO;
import com.matheusilvac.gym_track.domain.entity.cardio.Cardio;
import com.matheusilvac.gym_track.domain.entity.exercicio.Exercicio;
import com.matheusilvac.gym_track.domain.entity.series.Series;
import com.matheusilvac.gym_track.domain.entity.treino.Treino;
import com.matheusilvac.gym_track.domain.enums.modalidadeCardio.ModalidadeCardio;
import com.matheusilvac.gym_track.domain.enums.tipoSerieEnum.TipoSerieEnum;
import com.matheusilvac.gym_track.repository.CardioRepository;
import com.matheusilvac.gym_track.repository.ExercicioRepository;
import com.matheusilvac.gym_track.repository.SeriesRepository;
import com.matheusilvac.gym_track.repository.TreinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TreinoService {
    @Autowired
    private TreinoRepository treinoRepository;

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private CardioRepository cardioRepository;

    // Criar treino temporário
    public Treino criarTreinoTemporario(String nome) {
        Treino treino = new Treino();
        treino.setNome(nome);
        treino.setData(LocalDateTime.now());
        treino.setFinalizado(false);
        treinoRepository.save(treino);
        return treino;
    }

    public Page<Treino> obterTodos(Pageable paginacao) {
        return treinoRepository.findAllByOrderByDataAsc(paginacao);
    }

    @Transactional
    // Adicionar exercício ao treino
    public Exercicio adicionarExercicio(UUID treinoId, ExercicioDTO exercicioDTO) {
        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        if (treino.isFinalizado()) {
            throw new RuntimeException("Não é possível adicionar exercício a um treino finalizado.");
        }

        Exercicio exercicio = new Exercicio();
        exercicio.setNomeExercicio(exercicioDTO.getNomeExercicio());
        exercicio.setTreino(treino);
        exercicioRepository.save(exercicio);

        // Adicionando as séries
        for (SeriesDTO seriesDTO : exercicioDTO.getSeries()) {
            Series series = new Series();
            series.setTipoSerieEnum(TipoSerieEnum.valueOf(seriesDTO.getTipoSerieEnum()));
            series.setRepeticao(seriesDTO.getRepeticao());
            series.setCarga(seriesDTO.getCarga());
            series.setExercicio(exercicio);
            System.out.println("Salvando série: " + series);
            seriesRepository.save(series);
        }

        return exercicio;
    }

    //adicionar cardio
    @Transactional
    public Cardio adicionarCardio(UUID treinoId, CardioDTO cardioDTO) {
        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() -> new RuntimeException("Treino não encontrado"));
        if (treino.isFinalizado()) {
            throw new RuntimeException("Não é possível adicionar exercício a um treino finalizado.");
        }
        Cardio cardio = new Cardio();
        cardio.setModalidadeCardio(ModalidadeCardio.valueOf(cardioDTO.getModalidadeCardio()));
        cardio.setKm(cardioDTO.getKm());
        cardio.setTempo(cardioDTO.getTempo());
        if (cardioDTO.getKm() != null && cardioDTO.getKm() > 0) {
            cardio.setPace((double) cardioDTO.getTempo() / cardioDTO.getKm());
        } else {
            cardio.setPace(null);
        }

        treino.setCardio(cardio);

        cardioRepository.save(cardio);
        treinoRepository.save(treino);

        return cardio;
    }


    // Finalizar treino
    public Treino finalizarTreino(UUID treinoId) {
        Treino treino = treinoRepository.findById(treinoId).orElseThrow(() -> new RuntimeException("Treino não encontrado"));

        if (treino.isFinalizado()) {
            throw new RuntimeException("Treino já está finalizado.");
        }

        treino.setFinalizado(true);
        treinoRepository.save(treino);


        return treino;
    }

    public void excluirTreino(UUID id) {
        treinoRepository.deleteById(id);
    }
}
