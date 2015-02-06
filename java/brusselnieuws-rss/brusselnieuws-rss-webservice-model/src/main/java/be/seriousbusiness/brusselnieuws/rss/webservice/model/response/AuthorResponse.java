package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

/**
 * Web service response bean containing author data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class AuthorResponse extends AbstractIdResponse {
	private String name;
	
	/**
	 * Constructor solely used for {@link Mapper} functionality.
	 */
	public AuthorResponse() {}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
