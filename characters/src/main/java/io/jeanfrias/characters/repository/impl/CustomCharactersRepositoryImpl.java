package io.jeanfrias.characters.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.jeanfrias.characters.dto.Character;
import io.jeanfrias.characters.repository.CustomCharactersRepository;

@Repository
public class CustomCharactersRepositoryImpl implements CustomCharactersRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Character> findByQuery(StringBuffer query, Integer limit, Integer offset) {

		List<Character> result = new ArrayList<Character>();

		result = manager.createQuery(query.toString(), Character.class).setMaxResults(limit).setFirstResult(offset)
				.getResultList();

		return result;
	}

}
