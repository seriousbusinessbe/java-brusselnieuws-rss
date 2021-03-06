package be.seriousbusiness.brusselnieuws.rss.webservice.model.response;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Web service response bean managing a {@link Collection} of FeedMetaResponse(s).
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class FeedsMetaResponse {
	private Collection<FeedMetaResponse> feedMetaResponses=new ArrayList<FeedMetaResponse>();
	
	/**
	 * Constructor mandatory for Jackson REST mapping.
	 */
	public FeedsMetaResponse() {}
	
	/**
	 * Creates a new {@link FeedsMetaResponse} containing {@link FeedMetaResponse}(s).
	 * @param feedMetaResponses a non <code>null</code> {@link Collection} of {@link FeedMetaResponse}(s)
	 */
	public FeedsMetaResponse(final Collection<FeedMetaResponse> feedMetaResponses) {
		this.feedMetaResponses=feedMetaResponses;
	}

	/**
	 * Retrieves a {@link Collection} of {@link FeedMetaResponse}(s).
	 * @return a {@link Collection} of {@link FeedMetaResponse}(s) or empty when none found.
	 */
	public Collection<FeedMetaResponse> getFeedMetaResponses() {
		return feedMetaResponses;
	}

	/**
	 * Sets a {@link Collection} of {@link FeedMetaResponse}(s).
	 * @param feedMetaResponses a non <code>null</code> {@link Collection} of {@link FeedMetaResponse}(s)
	 */
	public void setFeedMetaResponses(final Collection<FeedMetaResponse> feedMetaResponses) {
		this.feedMetaResponses = feedMetaResponses;
	}
	
}
