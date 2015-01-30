package be.seriousbusiness.brusselnieuws.rss.webservice.model.controller;

import be.seriousbusiness.brusselnieuws.rss.webservice.model.response.FeedMetaListResponse;
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
	 * Returns a {@link FeedMetaListResponse} containing all retrievable feed.  
	 * @return a {@link FeedMetaListResponse}
	 */
	FeedMetaListResponse getFeedList();
	
	/**
	 * Returns a {@link FeedResponse} containing feed data corresponding to the requested id.
	 * @param id The feed request id
	 * @return a {@link FeedResponse}
	 */
	FeedResponse getFeed(final int id);

}
