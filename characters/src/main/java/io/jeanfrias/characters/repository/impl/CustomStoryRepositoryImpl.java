package io.jeanfrias.characters.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.jeanfrias.characters.dto.Story;
import io.jeanfrias.characters.repository.CustomStoryRepository;

@Repository
public class CustomStoryRepositoryImpl implements CustomStoryRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Story> findByQuery(StringBuffer query, Integer limit, Integer offset) {

		List<Story> result = new ArrayList<Story>();

		result = manager.createQuery(query.toString(), Story.class).setMaxResults(limit).setFirstResult(offset)
				.getResultList();

		return result;
	}

}
