package io.jeanfrias.characters.repository;

import java.util.List;

import io.jeanfrias.characters.dto.Character;

public interface CustomCharactersRepository {

	List<Character> findByQuery(StringBuffer query, Integer limit, Integer offset);
	
}
