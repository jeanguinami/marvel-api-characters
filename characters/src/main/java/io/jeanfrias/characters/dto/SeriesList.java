
package io.jeanfrias.characters.dto;

import java.util.List;

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
public class SeriesList {

	@Getter
	@Setter
	private Integer available;
	@Getter
	@Setter
	private Integer returned;
	@Getter
	@Setter
	private String collectionURI;
	@Getter
	@Setter
	private List<SeriesSummary> items = null;

}
