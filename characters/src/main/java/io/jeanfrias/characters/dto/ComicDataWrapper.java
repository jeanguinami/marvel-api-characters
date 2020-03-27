
package io.jeanfrias.characters.dto;

public class ComicDataWrapper {

	public ComicDataWrapper() {
		super();
	}

	public ComicDataWrapper(Integer code, String status, String copyright, String attributionText,
			String attributionHTML, ComicDataContainer data, String etag) {
		super();
		this.code = code;
		this.status = status;
		this.copyright = copyright;
		this.attributionText = attributionText;
		this.attributionHTML = attributionHTML;
		this.data = data;
		this.etag = etag;
	}

	private Integer code;

	private String status;

	private String copyright;

	private String attributionText;

	private String attributionHTML;

	private ComicDataContainer data;

	private String etag;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	public ComicDataContainer getData() {
		return data;
	}

	public void setData(ComicDataContainer data) {
		this.data = data;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

}
