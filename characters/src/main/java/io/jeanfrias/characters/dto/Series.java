
package io.jeanfrias.characters.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Series {

	public Series() {
		super();
	}

	public Series(Integer id, String title, String description, String resourceURI, List<Url> urls, Integer startYear,
			Integer endYear, String rating, Date modified, Image thumbnail, ComicList comics, StoryList stories,
			EventList events, CharacterList characters, CreatorList creators, SeriesSummary next) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.resourceURI = resourceURI;
		this.urls = urls;
		this.startYear = startYear;
		this.endYear = endYear;
		this.rating = rating;
		this.modified = modified;
		this.thumbnail = thumbnail;
		this.comics = comics;
		this.stories = stories;
		this.events = events;
		this.characters = characters;
		this.creators = creators;
		this.next = next;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private String description;

	private String resourceURI;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<Url> urls = null;

	private Integer startYear;

	private Integer endYear;

	private String rating;

	private Date modified;

	@ManyToOne
	@JoinColumn(name = "ID_IMAGE")
	private Image thumbnail;

	@ManyToOne
	@JoinColumn(name = "ID_COMIC_LIST")
	private ComicList comics;

	@ManyToOne
	@JoinColumn(name = "ID_STORY_LIST")
	private StoryList stories;

	@ManyToOne
	@JoinColumn(name = "ID_EVENT_LIST")
	private EventList events;

	@ManyToOne
	@JoinColumn(name = "ID_CHARACTER_LIST")
	private CharacterList characters;

	@ManyToOne
	@JoinColumn(name = "ID_CREATOR_LIST")
	private CreatorList creators;

	@ManyToOne
	@JoinColumn(name = "ID_SERIES_SUMMARY")
	private SeriesSummary next;

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

	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
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

	public StoryList getStories() {
		return stories;
	}

	public void setStories(StoryList stories) {
		this.stories = stories;
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

	public SeriesSummary getNext() {
		return next;
	}

	public void setNext(SeriesSummary next) {
		this.next = next;
	}

}
