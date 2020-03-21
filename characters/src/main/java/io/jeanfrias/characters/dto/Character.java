
package io.jeanfrias.characters.dto;

import java.sql.Date;
import java.util.List;

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
	private String resourceURI;
	@Getter
	@Setter
	private List<Url> urls = null;
	@Getter
	@Setter
	private Image thumbnail;
	@Getter
	@Setter
	private ComicList comics;
	@Getter
	@Setter
	private StoryList stories;
	@Getter
	@Setter
	private EventList events;
	@Getter
	@Setter
	private SeriesList series;

}
