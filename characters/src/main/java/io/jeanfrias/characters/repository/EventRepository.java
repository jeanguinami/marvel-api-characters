package io.jeanfrias.characters.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.jeanfrias.characters.dto.Event;

public interface EventRepository extends JpaRepository<Event, Integer>, CustomEventRepository {
	
}
