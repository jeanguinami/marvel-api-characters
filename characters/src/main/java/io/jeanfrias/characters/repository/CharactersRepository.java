package io.jeanfrias.characters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.jeanfrias.characters.dto.Character;

public interface CharactersRepository extends JpaRepository<Character, Integer>{
	
	//@Query("SELECT count(m) FROM Medico m WHERE (m.cpf = ?1) OR (m.email = ?2) OR ((m.crm = ?3) AND (m.estado = ?4))")
	//public int countCpfOrEmailOrCrmAndState(String cpf, String email, Long crm, UfsEnum uf);
	
	@Query("?1")
	public List<Character> findCharacters(String query);
}
