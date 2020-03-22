
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String title;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private String resourceURI;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<Url> urls = null;
	@Getter
	@Setter
	private Date modified;
	@Getter
	@Setter
	private Date start;
	@Getter
	@Setter
	private Date end;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_IMAGE")
	private Image thumbnail;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_COMIC_LIST")
	private ComicList comics;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_STORY_LIST")
	private StoryList stories;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_SERIES_LIST")
	private SeriesList series;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_CHARACTER_LIST")
	private CharacterList characters;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_CREATOR_LIST")
	private CreatorList creators;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_EVENT_SUMMARY")
	private EventSummary next;

}
