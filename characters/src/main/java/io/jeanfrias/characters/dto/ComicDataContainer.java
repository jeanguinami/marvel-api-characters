

package io.jeanfrias.characters.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComicDataContainer {

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
	private List<Comic> results = null;

}
