package io.jeanfrias.characters.repository;

import java.util.List;

import io.jeanfrias.characters.dto.Comic;

public interface CustomComicRepository {

	List<Comic> findByQuery(StringBuffer query, Integer limit, Integer offset);
	
}
