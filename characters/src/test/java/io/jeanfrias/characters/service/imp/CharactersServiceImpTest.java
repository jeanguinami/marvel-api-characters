package io.jeanfrias.characters.service.imp;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.jeanfrias.characters.dto.Character;
import io.jeanfrias.characters.repository.CharactersRepository;
import io.jeanfrias.characters.service.impl.CharactersServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CharactersServiceImpTest {

	@InjectMocks
	CharactersServiceImpl charactersService;

	@Mock
	CharactersRepository charactersRepository;

	@Test
	public void findCharactersSuccessfully() {

		//when(charactersRepository.findCharacters()).thenReturn(new ArrayList<Character>());

		//List<Character> character = charactersService.findCharacters(null, null, null, null, null, null, null, null,
			//	null, null);

		//verify(charactersRepository, times(1)).findCharacters();
	}
}
