package io.jeanfrias.characters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jeanfrias.characters.dto.Series;

public interface SeriesRepository extends JpaRepository<Series, Integer>, CustomSeriesRepository {
	
}
