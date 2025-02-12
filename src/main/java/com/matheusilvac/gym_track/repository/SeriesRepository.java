package com.matheusilvac.gym_track.repository;

import com.matheusilvac.gym_track.domain.entity.series.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
