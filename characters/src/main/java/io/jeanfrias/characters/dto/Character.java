
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private Date modified;
	@Getter
	@Setter
	@JoinColumn(name="RESOURCE_URI")
	private String resourceURI;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<Url> urls = null;
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
	@JoinColumn(name="ID_STORIES_LIST")
	private StoryList stories;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_EVENTS_LIST")
	private EventList events;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_SERIES_LIST")
	private SeriesList series;

}
