
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
public class Event {

	public Event() {
		super();
	}

	public Event(Integer id, String title, String description, String resourceURI, List<Url> urls, Date modified,
			Date start, Date end, Image thumbnail, ComicList comics, StoryList stories, SeriesList series,
			CharacterList characters, CreatorList creators, EventSummary next) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.resourceURI = resourceURI;
		this.urls = urls;
		this.modified = modified;
		this.start = start;
		this.end = end;
		this.thumbnail = thumbnail;
		this.comics = comics;
		this.stories = stories;
		this.series = series;
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

	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<Url> urls = null;

	private Date modified;

	private Date start;

	private Date end;

	@ManyToOne
	@JoinColumn(name="ID_IMAGE")
	private Image thumbnail;

	@ManyToOne
	@JoinColumn(name="ID_COMIC_LIST")
	private ComicList comics;

	@ManyToOne
	@JoinColumn(name="ID_STORY_LIST")
	private StoryList stories;

	@ManyToOne
	@JoinColumn(name="ID_SERIES_LIST")
	private SeriesList series;

	@ManyToOne
	@JoinColumn(name="ID_CHARACTER_LIST")
	private CharacterList characters;

	@ManyToOne
	@JoinColumn(name="ID_CREATOR_LIST")
	private CreatorList creators;

	@ManyToOne
	@JoinColumn(name="ID_EVENT_SUMMARY")
	private EventSummary next;

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

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
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

	public SeriesList getSeries() {
		return series;
	}

	public void setSeries(SeriesList series) {
		this.series = series;
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

	public EventSummary getNext() {
		return next;
	}

	public void setNext(EventSummary next) {
		this.next = next;
	}

}
