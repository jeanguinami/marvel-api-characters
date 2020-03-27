
package io.jeanfrias.characters.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Story {

	public Story() {
		super();
	}

	public Story(Integer id, String title, String description, String resourceURI, String type, Date modified,
			Image thumbnail, ComicList comics, SeriesList series, EventList events, CharacterList characters,
			CreatorList creators, ComicSummary originalissue) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.resourceURI = resourceURI;
		this.type = type;
		this.modified = modified;
		this.thumbnail = thumbnail;
		this.comics = comics;
		this.series = series;
		this.events = events;
		this.characters = characters;
		this.creators = creators;
		this.originalissue = originalissue;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String description;

	private String resourceURI;

	private String type;

	private Date modified;

	@ManyToOne
	@JoinColumn(name="ID_IMAGE")
	private Image thumbnail;

	@ManyToOne
	@JoinColumn(name="ID_COMIC_LIST")
	private ComicList comics;

	@ManyToOne
	@JoinColumn(name="ID_SERIES_LIST")
	private SeriesList series;

	@ManyToOne
	@JoinColumn(name="ID_EVENT_LIST")
	private EventList events;

	@ManyToOne
	@JoinColumn(name="ID_CHARACTER_LIST")
	private CharacterList characters;

	@ManyToOne
	@JoinColumn(name="ID_CREATOR_LIST")
	private CreatorList creators;

	@ManyToOne
	@JoinColumn(name="ID_COMIC_SUMMARY")
	private ComicSummary originalissue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResourceURI() {
		return resourceURI;
	}

	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public ComicList getComics() {
		return comics;
	}

	public void setComics(ComicList comics) {
		this.comics = comics;
	}

	public SeriesList getSeries() {
		return series;
	}

	public void setSeries(SeriesList series) {
		this.series = series;
	}

	public EventList getEvents() {
		return events;
	}

	public void setEvents(EventList events) {
		this.events = events;
	}

	public CharacterList getCharacters() {
		return characters;
	}

	public void setCharacters(CharacterList characters) {
		this.characters = characters;
	}

	public CreatorList getCreators() {
		return creators;
	}

	public void setCreators(CreatorList creators) {
		this.creators = creators;
	}

	public ComicSummary getOriginalissue() {
		return originalissue;
	}

	public void setOriginalissue(ComicSummary originalissue) {
		this.originalissue = originalissue;
	}

}
