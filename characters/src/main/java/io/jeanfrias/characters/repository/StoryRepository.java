package io.jeanfrias.characters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jeanfrias.characters.dto.Story;

public interface StoryRepository extends JpaRepository<Story, Integer>, CustomStoryRepository {
	
}
