package be.seriousbusiness.brusselnieuws.rss.reader;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

/**
 * Responsible for the retrieval of feed content provided by a link.
 * @author stefanborghys
 *
 * @param <FEED> the type of {@link Feed} to retrieve
 */
public interface BrusselNieuwsRssReader<FEED extends Feed<?,?,?,?,?>> {
	
	/**
	 * Update a {@link Feed} with new {@link Article}.</br>
	 * The {@link Feed} has to contain a valid link otherwise no RSS content can be retrieved.
	 * @param feed the feed to update
	 */
	void updateFeed(final FEED feed);
	
}
