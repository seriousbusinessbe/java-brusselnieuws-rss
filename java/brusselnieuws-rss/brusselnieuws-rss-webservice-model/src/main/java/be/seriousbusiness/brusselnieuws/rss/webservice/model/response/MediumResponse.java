package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

/**
 * Web service response bean containing medium data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumResponse {
	private long size;
	private String link;
	private String type;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	private MediumResponse() {}
	
	public long getSize() {
		return size;
	}
	
	public void setSize(final long size) {
		this.size = size;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(final String link) {
		this.link = link;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(final String type) {
		this.type = type;
	}

}
