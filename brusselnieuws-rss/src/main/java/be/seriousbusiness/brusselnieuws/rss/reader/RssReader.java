package be.seriousbusiness.brusselnieuws.rss.reader;

import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableFeed;

public interface RssReader {
	
	/**
	 * Set the AdaptableFeed which will be used to store new articles onto.
	 * @param adaptableFeed the feed which will be used to store new articles on
	 * @throws IllegalArgumentException when the feed is <code>null</code>
	 */
	void setAdaptableFeed(final AdaptableFeed adaptableFeed) throws IllegalArgumentException;
	
	/**
	 * Update the set Adaptable Feed with new articles if available at the moment.</br>
	 * When not feed is set, not action will be performed.
	 */
	void updateFeed();
}
