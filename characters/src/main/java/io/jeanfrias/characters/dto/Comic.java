
package io.jeanfrias.characters.dto;

import java.util.Date;
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
public class Comic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	@Getter
	@Setter
	private Integer digitalId;
	@Getter
	@Setter
	private String title;
	@Getter
	@Setter
	private Double issueNumber;
	@Getter
	@Setter
	private String variantDescription;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private Date modified;
	@Getter
	@Setter
	private String isbn;
	@Getter
	@Setter
	private String upc;
	@Getter
	@Setter
	private String diamondCode;
	@Getter
	@Setter
	private String ean;
	@Getter
	@Setter
	private String issn;
	@Getter
	@Setter
	private String format;
	@Getter
	@Setter
	private Integer pageCount;
	@Getter
	@Setter
	private List<TextObject> textObjects = null;
	@Getter
	@Setter
	private String resourceURI;
	@Getter
	@Setter
	private List<Url> urls = null;
	@Getter
	@Setter
	private SeriesSummary series;
	@Getter
	@Setter
	private List<ComicSummary> variants = null;
	@Getter
	@Setter
	private List<ComicSummary> collections = null;
	@Getter
	@Setter
	private List<ComicSummary> collectedIssues = null;
	@Getter
	@Setter
	private List<ComicDate> dates = null;
	@Getter
	@Setter
	private List<ComicPrice> prices = null;
	@Getter
	@Setter
	private Image thumbnail;
	@Getter
	@Setter
	private List<Image> images = null;
	@Getter
	@Setter
	private CreatorList creators;
	@Getter
	@Setter
	private CharacterList characters;
	@Getter
	@Setter
	private StoryList stories;

}
