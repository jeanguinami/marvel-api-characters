
package io.jeanfrias.characters.dto;

import java.util.List;

public class SeriesDataContainer {

	public SeriesDataContainer() {
		super();
	}

	public SeriesDataContainer(Integer offset, Integer limit, Integer total, Integer count, List<Series> results) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.total = total;
		this.count = count;
		this.results = results;
	}

	private Integer offset;

	private Integer limit;

	private Integer total;
	
	private Integer count;

	private List<Series> results = null;

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Series> getResults() {
		return results;
	}

	public void setResults(List<Series> results) {
		this.results = results;
	}

}
