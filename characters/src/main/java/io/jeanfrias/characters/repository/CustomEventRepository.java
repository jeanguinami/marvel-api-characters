package io.jeanfrias.characters.repository;

import java.util.List;

import io.jeanfrias.characters.dto.Event;

public interface CustomEventRepository {

	List<Event> findByQuery(StringBuffer query, Integer limit, Integer offset);
	
}
