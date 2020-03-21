
package io.jeanfrias.characters.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class Story {

	@Getter @Setter private Integer id;
	@Getter @Setter private String title;
	@Getter @Setter private String description;
	@Getter @Setter private String resourceURI;
	@Getter @Setter private String type;
	@Getter @Setter private Date modified;
	@Getter @Setter private Image thumbnail;
	@Getter @Setter private ComicList comics;
	@Getter @Setter private SeriesList series;
	@Getter @Setter private EventList events;
	@Getter @Setter private CharacterList characters;
	@Getter @Setter private CreatorList creators;
	@Getter @Setter private ComicSummary originalissue;

}
