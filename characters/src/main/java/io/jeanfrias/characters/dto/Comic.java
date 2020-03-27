
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
public class Comic {

	public Comic() {
		super();
	}

	public Comic(Integer id, Integer digitalId, String title, Double issueNumber, String variantDescription,
			String description, Date modified, String isbn, String upc, String diamondCode, String ean, String issn,
			String format, Integer pageCount, List<TextObject> textObjects, String resourceURI, List<Url> urls,
			SeriesSummary series, List<ComicSummary> variants, List<ComicSummary> collections,
			List<ComicSummary> collectedIssues, List<ComicDate> dates, List<ComicPrice> prices, Image thumbnail,
			List<Image> images, CreatorList creators, CharacterList characters, StoryList stories) {
		super();
		this.id = id;
		this.digitalId = digitalId;
		this.title = title;
		this.issueNumber = issueNumber;
		this.variantDescription = variantDescription;
		this.description = description;
		this.modified = modified;
		this.isbn = isbn;
		this.upc = upc;
		this.diamondCode = diamondCode;
		this.ean = ean;
		this.issn = issn;
		this.format = format;
		this.pageCount = pageCount;
		this.textObjects = textObjects;
		this.resourceURI = resourceURI;
		this.urls = urls;
		this.series = series;
		this.variants = variants;
		this.collections = collections;
		this.collectedIssues = collectedIssues;
		this.dates = dates;
		this.prices = prices;
		this.thumbnail = thumbnail;
		this.images = images;
		this.creators = creators;
		this.characters = characters;
		this.stories = stories;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer digitalId;

	private String title;

	private Double issueNumber;

	private String variantDescription;

	private String description;

	private Date modified;

	private String isbn;

	private String upc;

	private String diamondCode;

	private String ean;

	private String issn;

	private String format;

	private Integer pageCount;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<TextObject> textObjects = null;

	private String resourceURI;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<Url> urls = null;

	@ManyToOne
	@JoinColumn(name = "ID_SERIES_SUMMARY")
	private SeriesSummary series;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<ComicSummary> variants = null;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<ComicSummary> collections = null;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<ComicSummary> collectedIssues = null;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<ComicDate> dates = null;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<ComicPrice> prices = null;

	@ManyToOne
	@JoinColumn(name = "ID_IMAGE")
	private Image thumbnail;

	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
	private List<Image> images = null;

	@ManyToOne
	@JoinColumn(name = "ID_CREATOR_LIST")
	private CreatorList creators;

	@ManyToOne
	@JoinColumn(name = "ID_CHARACTER_LIST")
	private CharacterList characters;

	@ManyToOne
	@JoinColumn(name = "ID_STORY_LIST")
	private StoryList stories;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(Double issueNumber) {
		this.issueNumber = issueNumber;
	}

	public String getVariantDescription() {
		return variantDescription;
	}

	public void setVariantDescription(String variantDescription) {
		this.variantDescription = variantDescription;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getDiamondCode() {
		return diamondCode;
	}

	public void setDiamondCode(String diamondCode) {
		this.diamondCode = diamondCode;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List<TextObject> getTextObjects() {
		return textObjects;
	}

	public void setTextObjects(List<TextObject> textObjects) {
		this.textObjects = textObjects;
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

	public SeriesSummary getSeries() {
		return series;
	}

	public void setSeries(SeriesSummary series) {
		this.series = series;
	}

	public List<ComicSummary> getVariants() {
		return variants;
	}

	public void setVariants(List<ComicSummary> variants) {
		this.variants = variants;
	}

	public List<ComicSummary> getCollections() {
		return collections;
	}

	public void setCollections(List<ComicSummary> collections) {
		this.collections = collections;
	}

	public List<ComicSummary> getCollectedIssues() {
		return collectedIssues;
	}

	public void setCollectedIssues(List<ComicSummary> collectedIssues) {
		this.collectedIssues = collectedIssues;
	}

	public List<ComicDate> getDates() {
		return dates;
	}

	public void setDates(List<ComicDate> dates) {
		this.dates = dates;
	}

	public List<ComicPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ComicPrice> prices) {
		this.prices = prices;
	}

	public Image getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(Image thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public CreatorList getCreators() {
		return creators;
	}

	public void setCreators(CreatorList creators) {
		this.creators = creators;
	}

	public CharacterList getCharacters() {
		return characters;
	}

	public void setCharacters(CharacterList characters) {
		this.characters = characters;
	}

	public StoryList getStories() {
		return stories;
	}

	public void setStories(StoryList stories) {
		this.stories = stories;
	}

}
