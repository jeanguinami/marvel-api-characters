package io.jeanfrias.characters.repository;

import java.util.ArrayList;

import io.jeanfrias.characters.dto.Character;

public interface CharactersRepository {
	
	//@Query("SELECT count(m) FROM Medico m WHERE (m.cpf = ?1) OR (m.email = ?2) OR ((m.crm = ?3) AND (m.estado = ?4))")
	//public int countCpfOrEmailOrCrmAndState(String cpf, String email, Long crm, UfsEnum uf);
	
	public ArrayList<Character> findCharacters();
}
