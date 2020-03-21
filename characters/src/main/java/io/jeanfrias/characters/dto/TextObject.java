
package io.jeanfrias.characters.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TextObject {

	@Getter
	@Setter
	private String type;
	@Getter
	@Setter
	private String language;
	@Getter
	@Setter
	private String text;

}
