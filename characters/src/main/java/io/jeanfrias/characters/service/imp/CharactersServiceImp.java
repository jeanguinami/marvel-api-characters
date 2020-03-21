package io.jeanfrias.characters.service.imp;

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
	
	@Override
	public List<Character> findCharacters() {

		return charactersRepository.findCharacters();
	}

}
