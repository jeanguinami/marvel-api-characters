package io.jeanfrias.characters.service.imp;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

		if (name != null && !isBlank(name))
			params.put("name", name);
		if (nameStartsWith != null && !isBlank(nameStartsWith))
			params.put("nameStartsWith", nameStartsWith);
		// TODO CONTINUA AI PARÇA

		String query = createDynamicQuery(params);

		CharacterDataWrapper characters = new CharacterDataWrapper();

		characters.setCode(200);
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

		characters.getData().setResults(charactersRepository.findCharacters());

		return characters;
	}

	public String createDynamicQuery(HashMap<String, String> params) {
		StringBuffer query = new StringBuffer("SELECT * FROM CHARACTER WHERE ");
		Boolean isFirstParam = true;

		params.forEach((key, value) -> {
			if (isFirstParam) {
				if (key == "nameStartsWith") {
					query.append(key + " LIKE " + value + "%");
				} else {
					query.append(key + " = " + value);
				}
			} else {
				if (key == "nameStartsWith") {
					query.append(" AND " + key + " LIKE " + value + "%");
				} else {
					query.append(" AND " + key + " = " + value);
				}
			}
			
			isFirstParam = false;
		});
		return query.toString();

	}

}