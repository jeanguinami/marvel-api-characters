
package io.jeanfrias.characters.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Story {

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
	private String type;
	@Getter
	@Setter
	private Date modified;
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
	@JoinColumn(name="ID_SERIES_LIST")
	private SeriesList series;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_EVENT_LIST")
	private EventList events;
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
	@JoinColumn(name="ID_COMIC_SUMMARY")
	private ComicSummary originalissue;

}
