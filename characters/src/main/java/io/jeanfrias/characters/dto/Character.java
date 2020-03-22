
package io.jeanfrias.characters.dto;

import java.sql.Date;
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
public class Character {

	public Character() {
		super();
	}

	public Character(Integer id, String name, String description, Date modified, String resourceURI, List<Url> urls,
			Image thumbnail, ComicList comics, StoryList stories, EventList events, SeriesList series) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.modified = modified;
		this.resourceURI = resourceURI;
		this.urls = urls;
		this.thumbnail = thumbnail;
		this.comics = comics;
		this.stories = stories;
		this.events = events;
		this.series = series;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String name;

	private String description;

	private Date modified;

	@JoinColumn(name = "RESOURCE_URI")
	private String resourceURI;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<Url> urls = null;

	@ManyToOne
	@JoinColumn(name = "ID_IMAGE")
	private Image thumbnail;

	@ManyToOne
	@JoinColumn(name = "ID_COMIC_LIST")
	private ComicList comics;

	@ManyToOne
	@JoinColumn(name = "ID_STORIES_LIST")
	private StoryList stories;

	@ManyToOne
	@JoinColumn(name = "ID_EVENTS_LIST")
	private EventList events;

	@ManyToOne
	@JoinColumn(name = "ID_SERIES_LIST")
	private SeriesList series;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
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

	public SeriesList getSeries() {
		return series;
	}

	public void setSeries(SeriesList series) {
		this.series = series;
	}

}
