
package io.jeanfrias.characters.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CharacterDataContainer {

	@Getter
	@Setter
	private Integer offset;
	@Getter
	@Setter
	private Integer limit;
	@Getter
	@Setter
	private Integer total;
	@Getter
	@Setter
	private Integer count;
	@Getter
	@Setter
	private List<Character> results = null;

}