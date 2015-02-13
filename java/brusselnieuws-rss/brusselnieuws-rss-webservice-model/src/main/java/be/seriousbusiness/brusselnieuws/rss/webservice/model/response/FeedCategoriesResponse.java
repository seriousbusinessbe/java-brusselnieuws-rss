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
public class FeedCategoriesResponse {
	private Collection<String> feedCategories=new ArrayList<String>();

	/**
	 * Constructor mandatory for Jackson REST mapping.
	 */
	public FeedCategoriesResponse() {}
	
	/**
	 * Creates a new {@link FeedCategoriesResponse} containing a {@link Collection} of feed categories.
	 * @param feedMetaResponses a non <code>null</code> {@link Collection} of feed categories
	 */
	public FeedCategoriesResponse(final Collection<String> feedCategories) {
		this.feedCategories=feedCategories;
	}
	
	/**
	 * Retrieves a {@link Collection} of feed categories.
	 * @return a {@link Collection} of feed categories empty when none found.
	 */
	public Collection<String> getFeedCategories() {
		return feedCategories;
	}

	/**
	 * Sets a {@link Collection} of feed categories.
	 * @param feedCategories a non <code>null</code> {@link Collection} of feed categories
	 */
	public void setFeedCategories(final Collection<String> feedCategories) {
		this.feedCategories = feedCategories;
	}

}
