package be.seriousbusiness.brusselnieuws.rss.reader.model.listener;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

/**
 * Get notifications from a {@link Feed} when an {@link Article} is added.
 * @author stefanborghys
 */
public interface FeedListener {
	
	/**
	 * Notifies when an {@link Article} is added to a {@link Feed}.
	 * @param feed the {@link Feed} sending the notification
	 * @param article the added {@link Article}
	 */
	void notify(final Feed<?,?,?,?,?,?> feed,final Article<?,?,?,?,?> article);
}
