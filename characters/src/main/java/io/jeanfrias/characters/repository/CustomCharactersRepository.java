package io.jeanfrias.characters.repository;

import java.util.List;

import io.jeanfrias.characters.dto.Character;

public interface CustomCharactersRepository {

	List<Character> findByQuery(String query);
	
}
