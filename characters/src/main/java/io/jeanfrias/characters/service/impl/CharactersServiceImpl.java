package io.jeanfrias.characters.service.impl;

import static io.jeanfrias.characters.util.Strings.EMPTY_PARAMETER;
import static io.jeanfrias.characters.util.Strings.INVALID_LIMIT_ZERO;
import static io.jeanfrias.characters.util.Strings.INVALID_ORDERING;
import static io.jeanfrias.characters.util.Strings.INVALID_VALUE;
import static io.jeanfrias.characters.util.Strings.NO_RESULT;
import static io.jeanfrias.characters.util.Strings.TOO_MANY_FILTERS;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jeanfrias.characters.dto.CharacterDataContainer;
import io.jeanfrias.characters.dto.CharacterDataWrapper;
import io.jeanfrias.characters.dto.ComicDataContainer;
import io.jeanfrias.characters.dto.ComicDataWrapper;
import io.jeanfrias.characters.dto.EventDataContainer;
import io.jeanfrias.characters.dto.EventDataWrapper;
import io.jeanfrias.characters.dto.SeriesDataContainer;
import io.jeanfrias.characters.dto.SeriesDataWrapper;
import io.jeanfrias.characters.dto.StoriesDataWrapper;
import io.jeanfrias.characters.dto.StoryDataContainer;
import io.jeanfrias.characters.repository.CharactersRepository;
import io.jeanfrias.characters.repository.ComicRepository;
import io.jeanfrias.characters.repository.EventRepository;
import io.jeanfrias.characters.repository.SeriesRepository;
import io.jeanfrias.characters.repository.StoryRepository;
import io.jeanfrias.characters.service.CharactersService;

@Service
public class CharactersServiceImpl implements CharactersService {

	@Autowired
	CharactersRepository charactersRepository;

	@Autowired
	ComicRepository comicRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	SeriesRepository serieRepository;

	@Autowired
	StoryRepository storyRepository;

	CharacterDataWrapper character = new CharacterDataWrapper();
	ComicDataWrapper comic = new ComicDataWrapper();
	EventDataWrapper event = new EventDataWrapper();
	SeriesDataWrapper serie = new SeriesDataWrapper();
	StoriesDataWrapper story = new StoriesDataWrapper();
	HashMap<String, String> params = new HashMap<String, String>();
	SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public CharacterDataWrapper findCharactersByFilters(String name, String nameStartsWith, Date modifiedSince,
			List<String> comics, List<String> series, List<String> events, List<String> stories, List<String> orderBy,
			Integer limit, Integer offset) {

		character = new CharacterDataWrapper();
		StringBuffer query = new StringBuffer("SELECT C FROM Character C");
		CharacterDataContainer characterContainer = new CharacterDataContainer();

		if (name != null) {
			if (!name.isEmpty()) {
				params.put("name", name);
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (nameStartsWith != null) {
			if (!nameStartsWith.isEmpty()) {
				params.put("nameStartsWith", nameStartsWith);
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (modifiedSince != null) {
			if (!newFormat.format(modifiedSince).isEmpty()) {
				params.put("modified", newFormat.format(modifiedSince));
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (comics != null) {
			if (!comics.isEmpty()) {
				params.put("comics", comics.toString().replaceAll("[^0-9,]", ""));
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (series != null) {
			if (!series.isEmpty()) {
				params.put("series", series.toString().replaceAll("[^0-9,]", ""));
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (events != null) {
			if (!events.isEmpty()) {
				params.put("events", events.toString().replaceAll("[^0-9,]", ""));
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (stories != null) {
			if (!stories.isEmpty()) {
				params.put("stories", stories.toString().replaceAll("[^0-9,]", ""));
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return character;
			}
		}

		if (limit < 1 || limit > 100) {
			character.setCode(Integer.valueOf(409));
			character.setStatus(INVALID_LIMIT_ZERO);
			populateHeader();
			return character;
		}

		query.append(createDynamicQuery(params, true));

		characterContainer.setResults(charactersRepository.findByQuery(query, limit, offset));
		characterContainer.setTotal(charactersRepository.findAll().size());

		if (orderBy != null) {
			if (orderBy.size() > 0 || orderBy.size() <= 2) {
				List<String> orderByTemp = new ArrayList<String>();
				for (String s : orderBy) {
					if (!s.equals("name") || !s.equals("-name") || !s.equals("modified") || !s.equals("-modified")) {
						character.setCode(Integer.valueOf(409));
						character.setStatus(INVALID_ORDERING);
						populateHeader();
						return character;
					} else {
						orderByTemp.add(s);
					}
				}
				query.append((" ORDER BY C." + orderByTemp.toString().replaceAll("[^0-9,]", "")));
			} else {
				character.setCode(Integer.valueOf(409));
				character.setStatus(TOO_MANY_FILTERS);
				populateHeader();
				return character;
			}
		}
		character.setCode(Integer.valueOf(200));
		character.setStatus("OK");

		populateHeader();

		characterContainer.setOffset(offset);
		characterContainer.setLimit(limit);

		characterContainer.setResults(charactersRepository.findByQuery(query, limit, offset));
		character.setData(characterContainer);

		characterContainer.setCount(character.getData().getResults().size());

		return character;

	}

	@Override
	public CharacterDataWrapper getCharacterById(Integer id) {

		CharacterDataContainer characterContainer = new CharacterDataContainer();

		characterContainer.getResults()
				.add(charactersRepository.findById(id).orElseThrow(() -> new RuntimeException(NO_RESULT)));

		character.setData(characterContainer);
		character.setCode(Integer.valueOf(200));
		character.setStatus("OK");
		populateHeader();

		return character;
	}

	@Override
	public ComicDataWrapper getComicsByCharacter(Integer characterId, String format, String dateDescriptor,
			String title, String titleStartsWith, Integer issueNumber, String diamondCode, Integer digitalId,
			String upc, String isbn, String ean, String issn, Boolean hasDigitalIssue, Date modifiedSince,
			List<String> creators, List<String> series, List<String> events, List<String> stories, Integer limit,
			Integer offset) {

		ComicDataContainer comicContainer = new ComicDataContainer();
		StringBuffer query = new StringBuffer("SELECT C FROM Comic C");

		if (characterId != null) {
			if (!characterId.toString().isEmpty()) {

				/*
				 * character.getData().getResults().get(0); query.append(" WHERE C.id IN " +
				 * character.getData().getResults().get(0).getComics().toString().replaceAll(
				 * "[^0-9,]", ""));
				 */

				character.getData().getResults().add(getCharacterById(characterId).getData().getResults().get(0));
				query.append(" WHERE C.id IN " + character.getData().getResults().get(0).getComics().getItems()
						.toString().replaceAll("[^0-9,]", ""));
				if (format != null) {
					if (!format.isEmpty()) {
						params.put("format", format);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (dateDescriptor != null) {
					if (!dateDescriptor.isEmpty()) {

						LocalDate date = LocalDate.now();
						if (dateDescriptor.equalsIgnoreCase("lastWeek")) {
							params.put("dateDescriptor", newFormat.format(date.minusDays(7)) + " AND "
									+ newFormat.format(date.minusDays(14)));
						} else if (dateDescriptor.equalsIgnoreCase("thisWeek")) {
							params.put("dateDescriptor",
									newFormat.format(date) + " AND " + newFormat.format(date.minusDays(7)));
						} else if (dateDescriptor.equalsIgnoreCase("nextWeek")) {
							params.put("dateDescriptor",
									newFormat.format(date) + " AND " + newFormat.format(date.plusDays(7)));
						} else if (dateDescriptor.equalsIgnoreCase("thisMonth")) {
							params.put("dateDescriptor",
									newFormat.format(date) + " AND " + newFormat.format(date.minusMonths(1)));
						} else {
							params.put("dateDescriptor", dateDescriptor);
							comic.setCode(Integer.valueOf(409));
							comic.setStatus(INVALID_VALUE);
							populateHeader();
							return comic;
						}
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (title != null) {
					if (!title.isEmpty()) {
						params.put("title", title);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (titleStartsWith != null) {
					if (!titleStartsWith.isEmpty()) {
						params.put("titleStartsWith", titleStartsWith);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (issueNumber != null) {
					if (!issueNumber.toString().isEmpty()) {
						params.put("issueNumber", issueNumber.toString());
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (diamondCode != null) {
					if (!diamondCode.isEmpty()) {
						params.put("diamondCode", diamondCode);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (digitalId != null) {
					if (!digitalId.toString().isEmpty()) {
						params.put("digitalId", digitalId.toString());
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (upc != null) {
					if (!upc.isEmpty()) {
						params.put("upc", upc);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (isbn != null) {
					if (!isbn.isEmpty()) {
						params.put("isbn", isbn);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (ean != null) {
					if (!ean.isEmpty()) {
						params.put("ean", ean);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (issn != null) {
					if (!issn.isEmpty()) {
						params.put("issn", issn);
					}
				} else {
					comic.setCode(Integer.valueOf(409));
					comic.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return comic;
				}

				if (modifiedSince != null) {
					if (!newFormat.format(modifiedSince).isEmpty()) {
						params.put("modified", newFormat.format(modifiedSince));
					} else {
						comic.setCode(Integer.valueOf(409));
						comic.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return comic;
					}
				}

				if (creators != null) {
					if (!creators.isEmpty()) {
						params.put("creators", creators.toString().replaceAll("[^0-9,]", ""));
					} else {
						comic.setCode(Integer.valueOf(409));
						comic.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return comic;
					}
				}

				if (series != null) {
					if (!series.isEmpty()) {
						params.put("series", series.toString().replaceAll("[^0-9,]", ""));
					} else {
						comic.setCode(Integer.valueOf(409));
						comic.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return comic;
					}
				}

				if (events != null) {
					if (!events.isEmpty()) {
						params.put("events", events.toString().replaceAll("[^0-9,]", ""));
					} else {
						comic.setCode(Integer.valueOf(409));
						comic.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return comic;
					}
				}

				if (stories != null) {
					if (!stories.isEmpty()) {
						params.put("stories", stories.toString().replaceAll("[^0-9,]", ""));
					} else {
						comic.setCode(Integer.valueOf(409));
						comic.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return comic;
					}
				}

				query.append(createDynamicQuery(params, false));

				comicContainer.setResults(comicRepository.findByQuery(query, limit, offset));
				comicContainer.setTotal(comicRepository.findAll().size());

				comic.setCode(Integer.valueOf(200));
				comic.setStatus("OK");
				populateHeader();

				comicContainer.setOffset(offset);
				comicContainer.setLimit(limit);

				comicContainer.setResults(comicRepository.findByQuery(query, limit, offset));
				comic.setData(comicContainer);

				comicContainer.setCount(comic.getData().getResults().size());

				return comic;

			} else {
				comic.setCode(Integer.valueOf(409));
				comic.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return comic;
			}

		} else {
			comic.setCode(Integer.valueOf(409));
			comic.setStatus(EMPTY_PARAMETER);
			populateHeader();
			return comic;
		}
	}

	@Override
	public EventDataWrapper getEventsByCharacter(Integer characterId, String name, String nameStartsWith,
			Date modifiedSince, List<String> creators, List<String> series, List<String> comics, List<String> stories,
			List<String> orderBy, Integer limit, Integer offset) {

		EventDataContainer eventContainer = new EventDataContainer();
		StringBuffer query = new StringBuffer("SELECT C FROM Event C");

		if (characterId != null) {
			if (!characterId.toString().isEmpty()) {

				getCharacterById(characterId);

				character.getData().getResults().add(getCharacterById(characterId).getData().getResults().get(0));
				query.append(" WHERE C.id IN " + character.getData().getResults().get(0).getEvents().getItems()
						.toString().replaceAll("[^0-9,]", ""));

				if (name != null) {
					if (!name.isEmpty()) {
						params.put("name", name);
					}
				} else {
					event.setCode(Integer.valueOf(409));
					event.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return event;
				}

				if (nameStartsWith != null) {
					if (!nameStartsWith.isEmpty()) {
						params.put("nameStartsWith", nameStartsWith);
					}
				} else {
					event.setCode(Integer.valueOf(409));
					event.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return event;
				}

				if (modifiedSince != null) {
					if (!newFormat.format(modifiedSince).isEmpty()) {
						params.put("modified", newFormat.format(modifiedSince));
					} else {
						event.setCode(Integer.valueOf(409));
						event.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return event;
					}
				}

				if (creators != null) {
					if (!creators.isEmpty()) {
						params.put("creators", creators.toString().replaceAll("[^0-9,]", ""));
					} else {
						event.setCode(Integer.valueOf(409));
						event.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return event;
					}
				}

				if (series != null) {
					if (!series.isEmpty()) {
						params.put("series", series.toString().replaceAll("[^0-9,]", ""));
					} else {
						event.setCode(Integer.valueOf(409));
						event.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return event;
					}
				}

				if (comics != null) {
					if (!comics.isEmpty()) {
						params.put("comics", comics.toString().replaceAll("[^0-9,]", ""));
					} else {
						event.setCode(Integer.valueOf(409));
						event.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return event;
					}
				}

				if (stories != null) {
					if (!stories.isEmpty()) {
						params.put("stories", stories.toString().replaceAll("[^0-9,]", ""));
					} else {
						event.setCode(Integer.valueOf(409));
						event.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return event;
					}
				}

				query.append(createDynamicQuery(params, false));

				eventContainer.setResults(eventRepository.findByQuery(query, limit, offset));
				eventContainer.setTotal(eventRepository.findAll().size());

				event.setCode(Integer.valueOf(200));
				event.setStatus("OK");
				populateHeader();

				eventContainer.setOffset(offset);
				eventContainer.setLimit(limit);

				eventContainer.setResults(eventRepository.findByQuery(query, limit, offset));
				event.setData(eventContainer);

				eventContainer.setCount(event.getData().getResults().size());

				return event;

			} else {
				event.setCode(Integer.valueOf(409));
				event.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return event;
			}

		} else {
			event.setCode(Integer.valueOf(409));
			event.setStatus(EMPTY_PARAMETER);
			populateHeader();
			return event;
		}
	}

	@Override
	public SeriesDataWrapper getSeriesByCharacter(Integer characterId, String title, String titleStartsWith,
			Date modifiedSince, List<String> creators, List<String> events, List<String> comics, List<String> stories,
			List<String> orderBy, Integer limit, Integer offset) {

		SeriesDataContainer serieContainer = new SeriesDataContainer();
		StringBuffer query = new StringBuffer("SELECT C FROM Series C");

		if (characterId != null) {
			if (!characterId.toString().isEmpty()) {

				getCharacterById(characterId);

				character.getData().getResults().add(getCharacterById(characterId).getData().getResults().get(0));
				query.append(" WHERE C.id IN " + character.getData().getResults().get(0).getSeries().getItems()
						.toString().replaceAll("[^0-9,]", ""));

				if (title != null) {
					if (!title.isEmpty()) {
						params.put("title", title);
					}
				} else {
					serie.setCode(Integer.valueOf(409));
					serie.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return serie;
				}

				if (titleStartsWith != null) {
					if (!titleStartsWith.isEmpty()) {
						params.put("titleStartsWith", titleStartsWith);
					}
				} else {
					serie.setCode(Integer.valueOf(409));
					serie.setStatus(EMPTY_PARAMETER);
					populateHeader();
					return serie;
				}

				if (modifiedSince != null) {
					if (!newFormat.format(modifiedSince).isEmpty()) {
						params.put("modified", newFormat.format(modifiedSince));
					} else {
						serie.setCode(Integer.valueOf(409));
						serie.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return serie;
					}
				}

				if (creators != null) {
					if (!creators.isEmpty()) {
						params.put("creators", creators.toString().replaceAll("[^0-9,]", ""));
					} else {
						serie.setCode(Integer.valueOf(409));
						serie.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return serie;
					}
				}

				if (events != null) {
					if (!events.isEmpty()) {
						params.put("events", events.toString().replaceAll("[^0-9,]", ""));
					} else {
						serie.setCode(Integer.valueOf(409));
						serie.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return serie;
					}
				}

				if (comics != null) {
					if (!comics.isEmpty()) {
						params.put("comics", comics.toString().replaceAll("[^0-9,]", ""));
					} else {
						serie.setCode(Integer.valueOf(409));
						serie.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return serie;
					}
				}

				if (stories != null) {
					if (!stories.isEmpty()) {
						params.put("stories", stories.toString().replaceAll("[^0-9,]", ""));
					} else {
						serie.setCode(Integer.valueOf(409));
						serie.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return serie;
					}
				}

				query.append(createDynamicQuery(params, false));

				serieContainer.setResults(serieRepository.findByQuery(query, limit, offset));
				serieContainer.setTotal(serieRepository.findAll().size());

				serie.setCode(Integer.valueOf(200));
				serie.setStatus("OK");
				populateHeader();

				serieContainer.setOffset(offset);
				serieContainer.setLimit(limit);

				serieContainer.setResults(serieRepository.findByQuery(query, limit, offset));
				serie.setData(serieContainer);

				serieContainer.setCount(serie.getData().getResults().size());

				return serie;

			} else {
				serie.setCode(Integer.valueOf(409));
				serie.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return serie;
			}

		} else {
			serie.setCode(Integer.valueOf(409));
			serie.setStatus(EMPTY_PARAMETER);
			populateHeader();
			return serie;
		}

	}

	@Override
	public StoriesDataWrapper getStoriesByCharacter(Integer characterId, Date modifiedSince, List<String> creators,
			List<String> events, List<String> comics, List<String> series, List<String> orderBy, Integer limit,
			Integer offset) {

		StoryDataContainer storyContainer = new StoryDataContainer();
		StringBuffer query = new StringBuffer("SELECT C FROM Story C");

		if (characterId != null) {
			if (!characterId.toString().isEmpty()) {

				getCharacterById(characterId);

				character.getData().getResults().add(getCharacterById(characterId).getData().getResults().get(0));
				query.append(" WHERE C.id IN " + character.getData().getResults().get(0).getStories().getItems()
						.toString().replaceAll("[^0-9,]", ""));

				if (modifiedSince != null) {
					if (!newFormat.format(modifiedSince).isEmpty()) {
						params.put("modified", newFormat.format(modifiedSince));
					} else {
						story.setCode(Integer.valueOf(409));
						story.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return story;
					}
				}

				if (creators != null) {
					if (!creators.isEmpty()) {
						params.put("creators", creators.toString().replaceAll("[^0-9,]", ""));
					} else {
						story.setCode(Integer.valueOf(409));
						story.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return story;
					}
				}

				if (events != null) {
					if (!events.isEmpty()) {
						params.put("events", events.toString().replaceAll("[^0-9,]", ""));
					} else {
						story.setCode(Integer.valueOf(409));
						story.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return story;
					}
				}

				if (comics != null) {
					if (!comics.isEmpty()) {
						params.put("comics", comics.toString().replaceAll("[^0-9,]", ""));
					} else {
						story.setCode(Integer.valueOf(409));
						story.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return story;
					}
				}

				if (series != null) {
					if (!series.isEmpty()) {
						params.put("stories", series.toString().replaceAll("[^0-9,]", ""));
					} else {
						story.setCode(Integer.valueOf(409));
						story.setStatus(EMPTY_PARAMETER);
						populateHeader();
						return story;
					}
				}

				query.append(createDynamicQuery(params, false));

				storyContainer.setResults(storyRepository.findByQuery(query, limit, offset));
				storyContainer.setTotal(storyRepository.findAll().size());

				story.setCode(Integer.valueOf(200));
				story.setStatus("OK");
				populateHeader();

				storyContainer.setOffset(offset);
				storyContainer.setLimit(limit);

				storyContainer.setResults(storyRepository.findByQuery(query, limit, offset));
				story.setData(storyContainer);

				storyContainer.setCount(story.getData().getResults().size());

				return story;

			} else {
				story.setCode(Integer.valueOf(409));
				story.setStatus(EMPTY_PARAMETER);
				populateHeader();
				return story;
			}

		} else {
			story.setCode(Integer.valueOf(409));
			story.setStatus(EMPTY_PARAMETER);
			populateHeader();
			return story;
		}

	}

	public void populateHeader() {

		character.setCopyright("by Jean Frias");
		character.setAttributionText("API provided by Marvel. © 2020 MARVEL");
		character.setAttributionHTML("<a href=\"http://marvel.com\">API provided by Marvel. © 2020 MARVEL</a>");
		character.setEtag("mocked_etag");

	}

	public StringBuffer createDynamicQuery(HashMap<String, String> params, Boolean isFirstParam) {
		StringBuffer query = new StringBuffer();
		if (!params.isEmpty()) {

			for (Map.Entry<String, String> param : params.entrySet()) {

				if (isFirstParam) {
					if (param.getKey() == "nameStartsWith") {
						query.append(" WHERE C.name LIKE '" + param.getValue() + "%'");
					} else if (param.getKey() == "titleStartsWith") {
						query.append(" WHERE C.title LIKE '" + param.getValue() + "%'");
					} else if (param.getKey() == "comics" || param.getKey() == "series" || param.getKey() == "events"
							|| param.getKey() == "stories" || param.getKey() == "creators") {
						query.append(" WHERE C." + param.getKey() + " IN (" + param.getValue() + ")");
					} else if (param.getKey() == "modified") {
						query.append(" WHERE C." + param.getKey() + " > '" + param.getValue() + "'");
					} else {
						query.append(" WHERE C." + param.getKey() + " = '" + param.getValue() + "'");
					}
				} else {
					if (param.getKey() == "nameStartsWith") {
						query.append(" AND C.name LIKE '" + param.getValue() + "%'");
					} else if (param.getKey() == "titleStartsWith") {
						query.append(" AND C.title LIKE '" + param.getValue() + "%'");
					} else if (param.getKey() == "comics" || param.getKey() == "series" || param.getKey() == "events"
							|| param.getKey() == "stories" || param.getKey() == "creators") {
						query.append(" AND C." + param.getKey() + " IN (" + param.getValue() + ")");
					} else if (param.getKey() == "modified") {
						query.append(" AND C." + param.getKey() + " > '" + param.getValue() + "'");
					} else {
						query.append(" AND C." + param.getKey() + " = '" + param.getValue() + "'");
					}
				}

				isFirstParam = false;

			}

		}

		return query;
	}
}