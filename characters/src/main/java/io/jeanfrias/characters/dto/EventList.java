
package io.jeanfrias.characters.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class EventList {

	@Getter @Setter private Integer available;
	@Getter @Setter private Integer returned;
	@Getter @Setter private String collectionURI;
	@Getter @Setter private List<EventSummary> items = null;

}
