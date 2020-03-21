package io.jeanfrias.characters.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jeanfrias.characters.dto.Character;
import io.jeanfrias.characters.service.CharactersService;

@RestController
@RequestMapping("v1/public/characters")

public class CharactersController {
	
	@Autowired 
	CharactersService charactersService;
	
	@GetMapping
	public List<Character> getCharacters() {
		return charactersService.findCharacters();
	}
	
}
