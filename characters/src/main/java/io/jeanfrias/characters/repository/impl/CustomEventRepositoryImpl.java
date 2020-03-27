package io.jeanfrias.characters.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.jeanfrias.characters.dto.Event;
import io.jeanfrias.characters.repository.CustomEventRepository;

@Repository
public class CustomEventRepositoryImpl implements CustomEventRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Event> findByQuery(StringBuffer query, Integer limit, Integer offset) {

		List<Event> result = new ArrayList<Event>();

		result = manager.createQuery(query.toString(), Event.class).setMaxResults(limit).setFirstResult(offset)
				.getResultList();

		return result;
	}

}
