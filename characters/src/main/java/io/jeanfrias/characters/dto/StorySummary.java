
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
public class StorySummary {

	@Getter
	@Setter
	private String resourceURI;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String type;

}
