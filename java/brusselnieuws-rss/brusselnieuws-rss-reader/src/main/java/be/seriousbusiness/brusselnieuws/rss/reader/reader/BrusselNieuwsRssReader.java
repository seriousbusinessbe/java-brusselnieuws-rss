package be.seriousbusiness.brusselnieuws.rss.reader.reader;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

public interface BrusselNieuwsRssReader<FEED extends Feed<?,?,?,?,?>> {
	
	/**
	 * Update the set Adaptable Feed with new articles if available at the moment.</br>
	 * When not feed is set, not action will be performed.
	 */
	
	/**
	 * Update a {@link Feed} with new {@link Article}.
	 * @param feed
	 */
	void updateFeed(final FEED feed);
	
}
