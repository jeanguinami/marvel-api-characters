package io.jeanfrias.characters.service;

import java.util.List;

import io.jeanfrias.characters.dto.Character;

public interface CharactersService {
	
	public List<Character> findCharacters();
	
}
