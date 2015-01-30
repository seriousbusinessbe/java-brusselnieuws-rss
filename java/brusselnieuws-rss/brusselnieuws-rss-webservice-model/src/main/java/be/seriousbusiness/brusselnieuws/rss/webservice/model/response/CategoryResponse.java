package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

/**
 * Web service response bean containing category data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryResponse extends AbstractIdResponse {
	private String name;
	private String link;
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(final String link) {
		this.link = link;
	}

}
