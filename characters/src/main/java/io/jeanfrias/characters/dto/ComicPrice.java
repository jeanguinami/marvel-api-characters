
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
public class ComicPrice {

	@Getter
	@Setter
	private String type;
	@Getter
	@Setter
	private Float price;

}
