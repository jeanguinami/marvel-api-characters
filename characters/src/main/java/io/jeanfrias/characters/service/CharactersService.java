package io.jeanfrias.characters.service;

import java.util.Date;
import java.util.List;

import io.jeanfrias.characters.dto.CharacterDataWrapper;

public interface CharactersService {

	public CharacterDataWrapper findCharacters(String name, String nameStartsWith, Date modifiedSince, List<String> comics,
			List<String> series, List<String> events, List<String> stories, List<String> orderBy, Integer limit,
			Integer offset);

}
