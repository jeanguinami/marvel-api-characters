package io.jeanfrias.characters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.jeanfrias.characters.dto.Character;

public interface CharactersRepository extends JpaRepository<Character, Integer> {

	public List<Character> findCharacters(String query);
	
	public Integer countAllFiltered(String query);
}
