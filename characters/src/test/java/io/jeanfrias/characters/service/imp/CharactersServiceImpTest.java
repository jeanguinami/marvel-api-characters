package io.jeanfrias.characters.service.imp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import io.jeanfrias.characters.dto.Character;
import io.jeanfrias.characters.repository.CharactersRepository;

@RunWith(MockitoJUnitRunner.class)
public class CharactersServiceImpTest {

	@InjectMocks
	CharactersServiceImp charactersService;
	
	@Mock
	CharactersRepository charactersRepository;
	
	@Test
	public void findCharactersSuccessfully() {
		
		when(charactersRepository.findCharacters()).thenReturn(new ArrayList<Character>());
		
		List<Character> character = charactersService.findCharacters();
		
		verify(charactersRepository, times(1)).findCharacters();
	}
}
