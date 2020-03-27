package io.jeanfrias.characters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jeanfrias.characters.dto.Comic;

public interface ComicRepository extends JpaRepository<Comic, Integer>, CustomComicRepository {
	
}
