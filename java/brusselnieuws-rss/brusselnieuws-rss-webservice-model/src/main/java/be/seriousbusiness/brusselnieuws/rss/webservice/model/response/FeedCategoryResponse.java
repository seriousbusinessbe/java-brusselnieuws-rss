package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

/**
 * Web service response bean containing feed category data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedCategoryResponse {
	private String name;
	private String translatedName;
	
	/**
	 * Constructor mandatory for Jackson REST mapping.
	 */
	@SuppressWarnings("unused")
	private FeedCategoryResponse() {}
	
	public FeedCategoryResponse(final String name,final String translatedName) {
		setName(name);
		setTranslatedName(translatedName);
	}

	/**
	 * Retrieves a feed category name.
	 * @return feed category name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets a feed category name.
	 * @param name non empty, non <code>null</code> unique feed category name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Retrieves a translated feed category name.
	 * @return translated feed category name
	 */
	public String getTranslatedName() {
		return translatedName;
	}

	/**
	 * Sets a translated feed category name.
	 * @param translatedName non empty, non <code>null</code> translated feed category name
	 */
	public void setTranslatedName(final String translatedName) {
		this.translatedName = translatedName;
	}

}
