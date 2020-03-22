
package io.jeanfrias.characters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoriesDataWrapper {

	@Getter
	@Setter
	private Integer code;
	@Getter
	@Setter
	private String status;
	@Getter
	@Setter
	private String copyright;
	@Getter
	@Setter
	private String attributionText;
	@Getter
	@Setter
	private String attributionHTML;
	@Getter
	@Setter
	private StoryDataContainer data;
	@Getter
	@Setter
	private String etag;

}
