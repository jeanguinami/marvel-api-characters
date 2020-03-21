package io.jeanfrias.characters.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jeanfrias.characters.dto.Character;
import io.jeanfrias.characters.service.CharactersService;

@RestController
@RequestMapping("v1/public/characters")

public class CharactersController {

	@Autowired
	CharactersService charactersService;

	@GetMapping
	public List<Character> getCharacters(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "nameStartsWith", required = false) String nameStartsWith,
			@RequestParam(value = "modifiedSince", required = false) Date modifiedSince,
			@RequestParam(value = "comics", required = false) List<String> comics,
			@RequestParam(value = "series", required = false) List<String> series,
			@RequestParam(value = "events", required = false) List<String> events,
			@RequestParam(value = "stories", required = false) List<String> stories,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		return charactersService.findCharacters(name, nameStartsWith, modifiedSince, comics, series, events, stories,
				orderBy, limit, offset);
	}

}
/*
 * public ArrayList<MedicoPerfilResponse> getPerfilMedico(
 * 
 * @RequestParam(value = "nomeMedico", required = false) String nomeMedico,
 * 
 * @RequestParam(value = "crmMedico", required = false) Long crmMedico) { return
 * medicoService.getPerfilMedico(nomeMedico, crmMedico);
 */