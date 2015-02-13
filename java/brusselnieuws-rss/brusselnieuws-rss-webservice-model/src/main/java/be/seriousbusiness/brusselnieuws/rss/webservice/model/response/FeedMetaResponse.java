package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

/**
 * Web service response bean containing feed meta data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedMetaResponse {
	private String translatedName;
	private int requestId;
	private String category;
	
	/**
	 * Constructor mandatory for Jackson REST mapping.
	 */
	@SuppressWarnings("unused")
	private FeedMetaResponse() {}

	/**
	 * Creates a new {@link FeedMetaResponse} containing the required Dutch name, request id and category name.
	 * @param translatedName the translated name
	 * @param requestId the feed request id
	 * @param category the category name
	 */
	public FeedMetaResponse(final String translatedName,final int requestId,final String category) {
		setTranslatedName(translatedName);
		setRequestId(requestId);
		setCategory(category);
	}
		
	/**
	 * Retrieves this feed's translated name.
	 * @return translated feed name
	 */
	public String getTranslatedName() {
		return translatedName;
	}
	
	/**
	 * Sets this feed's translated name.
	 * @param non empty, non <code>null</code> translated feed name
	 */
	public void setTranslatedName(final String translatedName) {
		this.translatedName = translatedName;
	}
	
	/**
	 * Retrieves this feed request identifier,</br>
	 * which can be used to retrieve a {@link FeedResponse} using {@link FeedRestController}. 
	 * @return this feed's request id
	 * @see be.seriousbusiness.brusselnieuws.rss.webservice.model.controller.FeedRestController#getFeed(int)
	 */
	public int getRequestId() {
		return requestId;
	}
	
	/**
	 * Sets this feed request identifier.
	 * @param requestId unique request identifier
	 */
	public void setRequestId(final int requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * Retrieves this feed's category.
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Sets this feed's category.
	 * @param category non empty, non <code>null</code> category
	 */
	public void setCategory(final String category) {
		this.category = category;
	}

}
