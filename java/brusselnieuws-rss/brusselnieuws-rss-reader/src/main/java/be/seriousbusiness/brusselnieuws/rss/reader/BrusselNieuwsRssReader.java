package be.seriousbusiness.brusselnieuws.rss.reader;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

/**
 * Responsible for the retrieval of {@link Feed} content.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <FEED> the type of {@link Feed} to retrieve
 */
public interface BrusselNieuwsRssReader<FEED extends Feed<?,?,?,?,?,?>> {
	
	/**
	 * Updates a {@link Feed} with new {@link Article}(s) if found.</br>
	 * The {@link Feed} has to contain a valid link otherwise no RSS content can be retrieved.
	 * @param feed the feed to update
	 */
	void updateFeed(final FEED feed);
	
}
