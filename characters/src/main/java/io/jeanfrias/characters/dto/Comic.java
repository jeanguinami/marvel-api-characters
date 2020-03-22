
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
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<TextObject> textObjects = null;
	@Getter
	@Setter
	private String resourceURI;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<Url> urls = null;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_SERIES_SUMMARY")
	private SeriesSummary series;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<ComicSummary> variants = null;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<ComicSummary> collections = null;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<ComicSummary> collectedIssues = null;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<ComicDate> dates = null;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<ComicPrice> prices = null;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_IMAGE")
	private Image thumbnail;
	@Getter
	@Setter
	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<Image> images = null;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_CREATOR_LIST")
	private CreatorList creators;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_CHARACTER_LIST")
	private CharacterList characters;
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="ID_STORY_LIST")
	private StoryList stories;

}
