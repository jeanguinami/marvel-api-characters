package io.jeanfrias.characters.service;

import java.util.Date;
import java.util.List;

import io.jeanfrias.characters.dto.CharacterDataWrapper;
import io.jeanfrias.characters.dto.ComicDataWrapper;
import io.jeanfrias.characters.dto.EventDataWrapper;
import io.jeanfrias.characters.dto.SeriesDataWrapper;
import io.jeanfrias.characters.dto.StoriesDataWrapper;

public interface CharactersService {

	public CharacterDataWrapper findCharactersByFilters(String name, String nameStartsWith, Date modifiedSince,
			List<String> comics, List<String> series, List<String> events, List<String> stories, List<String> orderBy,
			Integer limit, Integer offset);

	public CharacterDataWrapper getCharacterById(Integer id);

	public ComicDataWrapper getComicsByCharacter(Integer characterId, String format, String dateDescriptor,
			String title, String titleStartsWith, Integer issueNumber, String diamondCode, Integer digitalId,
			String upc, String isbn, String ean, String issn, Boolean hasDigitalIssue, Date modifiedSince,
			List<String> creators, List<String> series, List<String> events, List<String> stories, Integer limit,
			Integer offset);

	public EventDataWrapper getEventsByCharacter(Integer characterId, String name, String nameStartsWith,
			Date modifiedSince, List<String> creators, List<String> series, List<String> comics, List<String> stories,
			List<String> orderBy, Integer limit, Integer offset);

	public SeriesDataWrapper getSeriesByCharacter(Integer characterId, String title, String titleStartsWith,
			Date modifiedSince, List<String> creators, List<String> events, List<String> comics, List<String> stories,
			List<String> orderBy, Integer limit, Integer offset);

	public StoriesDataWrapper getStoriesByCharacter(Integer characterId, Date modifiedSince, List<String> creators,
			List<String> events, List<String> comics, List<String> series, List<String> orderBy, Integer limit,
			Integer offset);
}
