
package io.jeanfrias.characters.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class StoryDataContainer {

	@Getter @Setter private Integer offset;
	@Getter @Setter private Integer limit;
	@Getter @Setter private Integer total;
	@Getter @Setter private Integer count;
	@Getter @Setter private List<Story> results = null;

}
