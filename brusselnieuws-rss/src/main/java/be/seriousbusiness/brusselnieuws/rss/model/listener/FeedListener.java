package be.seriousbusiness.brusselnieuws.rss.model.listener;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;

/**
 * Allows to get notified by a Feed when a new article is found.
 * @author stefanborghys
 *
 */
public interface FeedListener {
	
	/**
	 * Used to notify the implementer when a new article is found by a feed.
	 * @param feed the feed who sends the notification
	 * @param article the newly found article
	 */
	void notify(final Feed feed,final Article article);
}
