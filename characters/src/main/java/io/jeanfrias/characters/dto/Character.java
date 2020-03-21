
package io.jeanfrias.characters.dto;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Character {

	@Getter @Setter private Integer id;
	@Getter @Setter private String name;
	@Getter @Setter private String description;
	@Getter @Setter private Date modified;
	@Getter @Setter private String resourceURI;
	@Getter @Setter private List<Url> urls = null;
	@Getter @Setter private Image thumbnail;
	@Getter @Setter private ComicList comics;
	@Getter @Setter private StoryList stories;
	@Getter @Setter private EventList events;
	@Getter @Setter private SeriesList series;

}
