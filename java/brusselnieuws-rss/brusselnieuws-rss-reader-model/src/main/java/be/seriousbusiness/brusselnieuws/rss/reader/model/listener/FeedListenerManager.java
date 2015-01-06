package be.seriousbusiness.brusselnieuws.rss.reader.model.listener;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;

/**
 * Manages {@link FeedListener}.
 * @author stefanborghys
 * 
 */
public interface FeedListenerManager {
	
	/**
	 * Add a {@link FeedListener} to receive notifications when an {@link Article} is added.
	 * @param feedListener the {@link FeedListener} who wants to be notified
	 */
	void attach(final FeedListener feedListener);
	
	/**
	 * Remove a {@link FeedListener} so no more {@link Article} notifications are sended.
	 * @param feedListener the {@link FeedListener} who wants to be detach
	 */
	void detach(final FeedListener feedListener);

}
