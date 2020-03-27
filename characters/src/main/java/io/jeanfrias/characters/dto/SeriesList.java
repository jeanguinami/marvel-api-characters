
package io.jeanfrias.characters.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SERIES_LIST")
public class SeriesList {


	public SeriesList() {
		super();
	}

	public SeriesList(Integer available, Integer returned, String collectionURI, List<SeriesSummary> items) {
		super();
		this.available = available;
		this.returned = returned;
		this.collectionURI = collectionURI;
		this.items = items;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer available;

	private Integer returned;

	private String collectionURI;

	@OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	private List<SeriesSummary> items = null;

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public Integer getReturned() {
		return returned;
	}

	public void setReturned(Integer returned) {
		this.returned = returned;
	}

	public String getCollectionURI() {
		return collectionURI;
	}

	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}

	public List<SeriesSummary> getItems() {
		return items;
	}

	public void setItems(List<SeriesSummary> items) {
		this.items = items;
	}

}
