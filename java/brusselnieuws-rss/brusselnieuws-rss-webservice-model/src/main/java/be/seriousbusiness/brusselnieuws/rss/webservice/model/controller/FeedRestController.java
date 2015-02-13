package be.seriousbusiness.brusselnieuws.rss.webservice.model.controller;

import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedCategoriesResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedsMetaResponse;
import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedResponse;

/**
 * Feed REST (Representational state transfer) controller 
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface FeedRestController {
	
	/**
	 * Returns a {@link FeedCategoriesResponse} containing all feed categories
	 * @return a {@link FeedCategoriesResponse}
	 */
	FeedCategoriesResponse getFeedCategories();
	
	/**
	 * Returns a {@link FeedsMetaResponse} containing all retrievable feeds meta data.  
	 * @return a {@link FeedsMetaResponse}
	 */
	FeedsMetaResponse getFeedsMeta();
	
	/**
	 * Returns a {@link FeedResponse} containing feed data corresponding to the requested id.
	 * @param id The feed request id
	 * @return a {@link FeedResponse}
	 */
	FeedResponse getFeed(final int id);

}
