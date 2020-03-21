
package io.jeanfrias.characters.dto;

import lombok.Getter;
import lombok.Setter;

public class CharacterDataWrapper {

	@Getter @Setter private Integer code;
	@Getter @Setter private String status;
	@Getter @Setter private String copyright;
	@Getter @Setter private String attributionText;
	@Getter @Setter private String attributionHTML;
	@Getter @Setter private CharacterDataContainer data;
	@Getter @Setter private String etag;

}
