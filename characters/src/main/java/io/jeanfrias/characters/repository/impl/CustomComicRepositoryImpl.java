package io.jeanfrias.characters.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.jeanfrias.characters.dto.Comic;
import io.jeanfrias.characters.repository.CustomComicRepository;

@Repository
public class CustomComicRepositoryImpl implements CustomComicRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Comic> findByQuery(StringBuffer query, Integer limit, Integer offset) {

		List<Comic> result = new ArrayList<Comic>();

		result = manager.createQuery(query.toString(), Comic.class).setMaxResults(limit).setFirstResult(offset)
				.getResultList();

		return result;
	}

}
