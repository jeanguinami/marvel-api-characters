package io.jeanfrias.characters.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.jeanfrias.characters.dto.Series;
import io.jeanfrias.characters.repository.CustomSeriesRepository;

@Repository
public class CustomSeriesRepositoryImpl implements CustomSeriesRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Series> findByQuery(StringBuffer query, Integer limit, Integer offset) {

		List<Series> result = new ArrayList<Series>();

		result = manager.createQuery(query.toString(), Series.class).setMaxResults(limit).setFirstResult(offset)
				.getResultList();

		return result;
	}

}
