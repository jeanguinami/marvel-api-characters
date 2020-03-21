
package io.jeanfrias.characters.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Image thumbnail;
	@Getter
	@Setter
	private ComicList comics;
	@Getter
	@Setter
	private SeriesList series;
	@Getter
	@Setter
	private EventList events;
	@Getter
	@Setter
	private CharacterList characters;
	@Getter
	@Setter
	private CreatorList creators;
	@Getter
	@Setter
	private ComicSummary originalissue;

}
