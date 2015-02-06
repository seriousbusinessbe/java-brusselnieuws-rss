package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

/**
 * Web service response bean containing feed meta data.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedMetaResponse {
	private String dutchName;
	private int requestId;
	private String category;
	
	/**
	 * Constructor mandatory for Jackson REST mapping.
	 */
	public FeedMetaResponse() {}

	
	/**
	 * Creates a new {@link FeedMetaResponse} containing the required Dutch name, request id and category name.
	 * @param dutchName the Dutch name
	 * @param requestId the feed request id
	 * @param category the category name
	 */
	public FeedMetaResponse(final String dutchName,final int requestId,final String category) {
		setDutchName(dutchName);
		setRequestId(requestId);
		setCategory(category);
	}
		
	/**
	 * Retrieves this feed name in Dutch.
	 * @return Dutch feed name
	 */
	public String getDutchName() {
		return dutchName;
	}
	
	/**
	 * Sets this feed name in Dutch.
	 * @param dutchName non empty, non <code>null</code> unique name
	 */
	public void setDutchName(final String dutchName) {
		this.dutchName = dutchName;
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
	 * Retrieves this feed's category
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Sets this feed's category
	 * @param category non empty, non <code>null</code> category
	 */
	public void setCategory(final String category) {
		this.category = category;
	}

}
