package io.jeanfrias.characters.repository;

import java.util.List;

import io.jeanfrias.characters.dto.Story;

public interface CustomStoryRepository {

	List<Story> findByQuery(StringBuffer query, Integer limit, Integer offset);
	
}
