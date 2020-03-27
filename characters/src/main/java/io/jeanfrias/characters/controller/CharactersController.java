package io.jeanfrias.characters.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jeanfrias.characters.dto.CharacterDataWrapper;
import io.jeanfrias.characters.dto.ComicDataWrapper;
import io.jeanfrias.characters.dto.EventDataWrapper;
import io.jeanfrias.characters.dto.SeriesDataWrapper;
import io.jeanfrias.characters.dto.StoriesDataWrapper;
import io.jeanfrias.characters.service.CharactersService;

@RestController
@RequestMapping("v1/public/characters")

public class CharactersController {

	@Autowired
	CharactersService charactersService;

	@GetMapping
	public CharacterDataWrapper getCharacters(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "nameStartsWith", required = false) String nameStartsWith,
			@RequestParam(value = "modifiedSince", required = false) Date modifiedSince,
			@RequestParam(value = "comics", required = false) List<String> comics,
			@RequestParam(value = "series", required = false) List<String> series,
			@RequestParam(value = "events", required = false) List<String> events,
			@RequestParam(value = "stories", required = false) List<String> stories,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		return charactersService.findCharactersByFilters(name, nameStartsWith, modifiedSince, comics, series, events,
				stories, orderBy, limit, offset);
	}

	@GetMapping("/{characterId}")
	public CharacterDataWrapper getCharacterById(@PathVariable("characterId") Integer characterId) {

		return charactersService.getCharacterById(characterId);
	}

	@GetMapping("/{characterId}/comics")
	public ComicDataWrapper getComicsByCharacter(@PathVariable("characterId") Integer characterId,
			@RequestParam(value = "format", required = false) String format,
			@RequestParam(value = "dateDescriptor", required = false) String dateDescriptor,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "titleStartsWith", required = false) String titleStartsWith,
			@RequestParam(value = "issueNumber", required = false) Integer issueNumber,
			@RequestParam(value = "diamondCode", required = false) String diamondCode,
			@RequestParam(value = "digitalId", required = false) Integer digitalId,
			@RequestParam(value = "upc", required = false) String upc,
			@RequestParam(value = "isbn", required = false) String isbn,
			@RequestParam(value = "ean", required = false) String ean,
			@RequestParam(value = "issn", required = false) String issn,
			@RequestParam(value = "hasDigitalIssue", required = false) Boolean hasDigitalIssue,
			@RequestParam(value = "modifiedSince", required = false) Date modifiedSince,
			@RequestParam(value = "creators", required = false) List<String> creators,
			@RequestParam(value = "series", required = false) List<String> series,
			@RequestParam(value = "events", required = false) List<String> events,
			@RequestParam(value = "stories", required = false) List<String> stories,
			@RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		return charactersService.getComicsByCharacter(characterId, format, dateDescriptor, title, titleStartsWith,
				issueNumber, diamondCode, digitalId, upc, isbn, ean, issn, hasDigitalIssue, modifiedSince, creators,
				series, events, stories, limit, offset);
	}

	@GetMapping("/{characterId}/events")
	public EventDataWrapper getEventsByCharacter(@PathVariable("characterId") Integer characterId,
			@RequestParam(value = "title", required = false) String name,
			@RequestParam(value = "titleStartsWith", required = false) String nameStartsWith,
			@RequestParam(value = "modifiedSince", required = false) Date modifiedSince,
			@RequestParam(value = "creators", required = false) List<String> creators,
			@RequestParam(value = "series", required = false) List<String> series,
			@RequestParam(value = "comics", required = false) List<String> comics,
			@RequestParam(value = "stories", required = false) List<String> stories,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		return charactersService.getEventsByCharacter(characterId, name, nameStartsWith, modifiedSince, creators,
				series, comics, stories, orderBy, limit, offset);
	}

	@GetMapping("/{characterId}/series")
	public SeriesDataWrapper getSeriesByCharacter(@PathVariable("characterId") Integer characterId,
			@RequestParam(value = "title", required = false) String title,
			@RequestParam(value = "titleStartsWith", required = false) String titleStartsWith,
			@RequestParam(value = "modifiedSince", required = false) Date modifiedSince,
			@RequestParam(value = "creators", required = false) List<String> creators,
			@RequestParam(value = "events", required = false) List<String> events,
			@RequestParam(value = "comics", required = false) List<String> comics,
			@RequestParam(value = "stories", required = false) List<String> stories,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		return charactersService.getSeriesByCharacter(characterId, title, titleStartsWith, modifiedSince, creators,
				events, comics, stories, orderBy, limit, offset);
	}

	@GetMapping("/{characterId}/stories")
	public StoriesDataWrapper getStoriesByCharacter(@PathVariable("characterId") Integer characterId,
			@RequestParam(value = "modifiedSince", required = false) Date modifiedSince,
			@RequestParam(value = "creators", required = false) List<String> creators,
			@RequestParam(value = "events", required = false) List<String> events,
			@RequestParam(value = "comics", required = false) List<String> comics,
			@RequestParam(value = "series", required = false) List<String> series,
			@RequestParam(value = "orderBy", required = false) List<String> orderBy,
			@RequestParam(value = "limit", required = false, defaultValue = "100") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		return charactersService.getStoriesByCharacter(characterId, modifiedSince, creators, events, comics, series,
				orderBy, limit, offset);
	}
}