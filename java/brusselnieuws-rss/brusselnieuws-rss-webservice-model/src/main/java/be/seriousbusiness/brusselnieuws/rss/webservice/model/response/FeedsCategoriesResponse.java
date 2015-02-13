package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Web service response bean managing a {@link Collection} of feed categories.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedsCategoriesResponse {
	private Collection<FeedCategoryResponse> feedCategoryResponses=new ArrayList<FeedCategoryResponse>();

	/**
	 * Constructor mandatory for Jackson REST mapping.
	 */
	@SuppressWarnings("unused")
	private FeedsCategoriesResponse() {}
	
	/**
	 * Creates a new {@link FeedsCategoriesResponse} containing a {@link Collection} of {@link FeedCategoryResponse}.
	 * @param feedMetaResponses a non <code>null</code> {@link Collection} of {@link FeedCategoryResponse}
	 */
	public FeedsCategoriesResponse(final Collection<FeedCategoryResponse> feedCategoryResponses) {
		this.feedCategoryResponses=feedCategoryResponses;
	}
	
	/**
	 * Retrieves a {@link Collection} of {@link FeedCategoryResponse}.
	 * @return a {@link Collection} of {@link FeedCategoryResponse} empty when none found.
	 */
	public Collection<FeedCategoryResponse> getFeedCategoryResponses() {
		return feedCategoryResponses;
	}

	/**
	 * Sets a {@link Collection} of {@link FeedCategoryResponse}.
	 * @param feedCategories a non <code>null</code> {@link Collection} of {@link FeedCategoryResponse}
	 */
	public void setFeedCategoryResponses(final Collection<FeedCategoryResponse> feedCategoryResponses) {
		this.feedCategoryResponses = feedCategoryResponses;
	}

}
