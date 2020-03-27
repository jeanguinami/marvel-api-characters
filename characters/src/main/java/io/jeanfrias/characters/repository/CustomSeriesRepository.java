package io.jeanfrias.characters.repository;

import java.util.List;

import io.jeanfrias.characters.dto.Series;

public interface CustomSeriesRepository {

	List<Series> findByQuery(StringBuffer query, Integer limit, Integer offset);
	
}
