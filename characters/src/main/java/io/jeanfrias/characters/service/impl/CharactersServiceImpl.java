package io.jeanfrias.characters.service.impl;

import static io.jeanfrias.characters.util.Strings.EMPTY_PARAMETER;
import static io.jeanfrias.characters.util.Strings.INVALID_LIMIT_ABOVE;
import static io.jeanfrias.characters.util.Strings.INVALID_LIMIT_ZERO;
import static io.jeanfrias.characters.util.Strings.INVALID_PARAMETER;
import static io.jeanfrias.characters.util.Strings.TOO_MANY_FILTERS;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jeanfrias.characters.dto.CharacterDataContainer;
import io.jeanfrias.characters.dto.CharacterDataWrapper;
import io.jeanfrias.characters.repository.CharactersRepository;
import io.jeanfrias.characters.service.CharactersService;

@Service
public class CharactersServiceImpl implements CharactersService {

	@Autowired
	CharactersRepository charactersRepository;

	@Override
	public CharacterDataWrapper findCharactersByFilters(String name, String nameStartsWith, Date modifiedSince,
			List<String> comics, List<String> series, List<String> events, List<String> stories, List<String> orderBy,
			Integer limit, Integer offset) {

		CharacterDataWrapper characters = new CharacterDataWrapper();
		HashMap<String, String> params = new HashMap<String, String>();
		CharacterDataContainer characterContainer = new CharacterDataContainer();
		String query = null;

		if (name != null) {
			if (!name.isEmpty()) {
				params.put("name", name);
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (nameStartsWith != null) {
			if (!nameStartsWith.isEmpty()) {
				params.put("nameStartsWith", nameStartsWith);
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (modifiedSince != null) {
			if (!modifiedSince.toString().isEmpty()) {
				params.put("modifiedSince", modifiedSince.toString());
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (nameStartsWith != null) {
			if (!nameStartsWith.isEmpty()) {
				params.put("nameStartsWith", nameStartsWith);
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (comics != null) {
			if (!comics.isEmpty()) {
				params.put("comics", comics.toString());
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (series != null) {
			if (!series.isEmpty()) {
				params.put("series", series.toString());
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (events != null) {
			if (!events.isEmpty()) {
				params.put("events", events.toString());
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		if (stories != null) {
			if (!stories.isEmpty()) {
				params.put("stories", stories.toString());
			} else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(EMPTY_PARAMETER);
				return characters;
			}
		}

		query = createDynamicQuery(params);

		characterContainer.setTotal(characters.getData().getResults().size());

		if (orderBy.toString() != null) {
			if (orderBy.size() <= 2)
				query.concat("ORDER BY " + orderBy.toString());
			else {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(TOO_MANY_FILTERS);
				return characters;
			}
		}

		if (limit <= 100) {
			if (limit < 1) {
				characters.setCode(Integer.valueOf(409));
				characters.setStatus(INVALID_LIMIT_ZERO);
				return characters;
			} else {
				query.concat("LIMIT " + limit);
			}
		} else {
			characters.setCode(Integer.valueOf(409));
			characters.setStatus(INVALID_LIMIT_ABOVE);
			return characters;
		}

		if (offset >= 0) {
			query.concat(", " + offset);
		} else {
			characters.setCode(Integer.valueOf(409));
			characters.setStatus(INVALID_PARAMETER);
			return characters;
		}

		characters.setCode(Integer.valueOf(200));
		characters.setStatus("OK.");
		characters.setCopyright("by Jean Frias");
		characters.setAttributionText("API provided by Marvel. © 2020 MARVEL");
		characters.setAttributionHTML("<a href=\"http://marvel.com\">API provided by Marvel. © 2020 MARVEL</a>");
		characters.setEtag("mocked_etag");

		characterContainer.setOffset(offset);
		characterContainer.setLimit(limit);

		characterContainer.setResults(charactersRepository.findByQuery(query));
		characters.setData(characterContainer);

		characterContainer.setCount(characters.getData().getResults().size());

		return characters;
	}

	public String createDynamicQuery(HashMap<String, String> params) {
		StringBuffer query = new StringBuffer("SELECT * FROM CHARACTER ");
		Boolean isFirstParam = true;
		if (!params.isEmpty()) {

			for (Map.Entry<String, String> param : params.entrySet()) {

				if (isFirstParam) {
					if (param.getKey() == "nameStartsWith") {
						query.append("WHERE " + param.getKey() + " LIKE " + param.getValue() + "%");
					} else if (param.getKey() == "comics" || param.getKey() == "series" || param.getKey() == "events"
							|| param.getKey() == "stories") {
						query.append("WHERE " + param.getKey() + " IN (" + param.getValue() + ")");
					} else {
						query.append("WHERE " + param.getKey() + " = " + param.getValue());
					}
				} else {
					if (param.getKey() == "nameStartsWith") {
						query.append(" AND " + param.getKey() + " LIKE " + param.getValue() + "%");
					} else if (param.getKey() == "comics" || param.getKey() == "series" || param.getKey() == "events"
							|| param.getKey() == "stories") {
						query.append(" AND " + param.getKey() + " IN (" + param.getValue() + ")");
					} else {
						query.append(" AND " + param.getKey() + " = " + param.getValue());
					}
				}

				isFirstParam = false;

			}

		}

		System.out.println(query);

		return query.toString();
	}

}