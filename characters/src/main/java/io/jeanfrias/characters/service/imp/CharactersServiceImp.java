package io.jeanfrias.characters.service.imp;

import static io.jeanfrias.characters.util.Strings.TOO_MANY_FILTERS;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jeanfrias.characters.dto.Character;
import io.jeanfrias.characters.repository.CharactersRepository;
import io.jeanfrias.characters.service.CharactersService;

@Service
public class CharactersServiceImp implements CharactersService {

	@Autowired
	CharactersRepository charactersRepository;

	@SuppressWarnings("null")
	@Override
	public List<Character> findCharacters(String name, String nameStartsWith, Date modifiedSince, List<String> comics,
			List<String> series, List<String> events, List<String> stories, List<String> orderBy, Integer limit,
			Integer offset) {

		Boolean isAInvalidFilter = false;
		
		if (orderBy == null) {

			orderBy.add("id");

		} else if (orderBy.size() <= 2) {
			
			orderBy.forEach((order) -> {if(order != "name" || order != "-name" || order != "modifiedSince" || order != "-modifiedSince") {

			}});
			
			
		} else if (orderBy.size() > 2) {

			throw new RuntimeException(TOO_MANY_FILTERS);
		}

		List<Character> charactersList = charactersRepository.findCharacters();

		return charactersList;
	}
}
