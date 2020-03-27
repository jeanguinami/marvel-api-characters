package io.jeanfrias.characters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jeanfrias.characters.dto.Character;

public interface CharactersRepository extends JpaRepository<Character, Integer>, CustomCharactersRepository {
	
}
