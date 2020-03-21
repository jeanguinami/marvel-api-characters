
package io.jeanfrias.characters.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Event {

	@Getter @Setter private Integer id;
	@Getter @Setter private String title;
	@Getter @Setter private String description;
    @Getter @Setter private String resourceURI;
    @Getter @Setter private List<Url> urls = null;
    @Getter @Setter private Date modified;
    @Getter @Setter private Date start;
    @Getter @Setter private Date end;
    @Getter @Setter private Image thumbnail;
    @Getter @Setter private ComicList comics;
    @Getter @Setter private StoryList stories;
    @Getter @Setter private SeriesList series;
    @Getter @Setter private CharacterList characters;
    @Getter @Setter private CreatorList creators;
    @Getter @Setter private EventSummary next;
    @Getter @Setter private EventSummary previous;

}
