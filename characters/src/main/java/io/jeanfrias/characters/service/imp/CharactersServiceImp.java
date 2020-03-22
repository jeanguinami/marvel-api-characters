package io.jeanfrias.characters.service.imp;

import static io.jeanfrias.characters.util.Strings.EMPTY_PARAMETER;
import static io.jeanfrias.characters.util.Strings.TOO_MANY_FILTERS;
import static io.jeanfrias.characters.util.Strings.INVALID_LIMIT_ZERO;
import static io.jeanfrias.characters.util.Strings.INVALID_LIMIT_ABOVE;
import static io.jeanfrias.characters.util.Strings.INVALID_PARAMETER;

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
public class CharactersServiceImp implements CharactersService {

	@Autowired
	CharactersRepository charactersRepository;

	@Override
	public CharacterDataWrapper findCharacters(String name, String nameStartsWith, Date modifiedSince,
			List<String> comics, List<String> series, List<String> events, List<String> stories, List<String> orderBy,
			Integer limit, Integer offset) {

		HashMap<String, String> params = new HashMap<String, String>();

		CharacterDataWrapper characters = new CharacterDataWrapper();

		if (name != "" && nameStartsWith != "" && modifiedSince.toString() != "" && comics.toString() != ""
				&& series.toString() != "" && events.toString() != "" && stories.toString() != ""
				&& orderBy.toString() != "" && limit.toString() != "" && offset.toString() != "") {
			if (name != null) {
				params.put("name", name);
			}

			if (nameStartsWith != null) {
				params.put("nameStartsWith", nameStartsWith);
			}

			if (modifiedSince != null) {
				params.put("modifiedSince", modifiedSince.toString());
			}

			if (comics.toString() != null) {
				params.put("comics", comics.toString());
			}

			if (series.toString() != null) {
				params.put("series", series.toString());
			}

			if (events.toString() != null) {
				params.put("events", events.toString());
			}

			if (stories.toString() != null) {
				params.put("stories", stories.toString());
			}

			String query = createDynamicQuery(params);

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
			
			CharacterDataContainer characterContainer = new CharacterDataContainer();
			characterContainer.setOffset(offset);
			characterContainer.setLimit(limit);
			
			// characterContainer.setTotal(charactersRepository.countAllFiltered());
			// characterContainer.setCount(charactersRepository.findCharacters().size());

			characters.setData(characterContainer);

			characters.getData().setResults(charactersRepository.findCharacters(query));

		} else {
			characters.setCode(Integer.valueOf(409));
			characters.setStatus(EMPTY_PARAMETER);
			return characters;
		}

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

		return query.toString();
	}

}