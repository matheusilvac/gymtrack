package com.matheusilvac.gym_track.domain.entity.series;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Exercicio exercicio;

    public Series() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoSerieEnum getTipoSerieEnum() {
        return tipoSerieEnum;
    }

    public void setTipoSerieEnum(TipoSerieEnum tipoSerieEnum) {
        this.tipoSerieEnum = tipoSerieEnum;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }

    public Integer getCarga() {
        return carga;
    }

    public void setCarga(Integer carga) {
        this.carga = carga;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }
}
