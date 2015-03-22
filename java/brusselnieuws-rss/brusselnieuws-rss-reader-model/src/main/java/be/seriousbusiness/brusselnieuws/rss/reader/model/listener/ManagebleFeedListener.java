package be.seriousbusiness.brusselnieuws.rss.reader.model.listener;

import java.util.Collection;
import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

/**
 * {@link FeedListener} which can be used to manage it's notifications over a given time.
 * @author stefanborghys
 */
public interface ManagebleFeedListener extends FeedListener {
	
	/**
	 * Resets the number of received notifications to O</br>
	 * and clears the received articles and feeds.
	 */
	void reset();
	
	/**
	 * Returns the number of received notifications since the creation of this {@link ManagebleFeedListener} 
	 * or the last {@link ManagebleFeedListener#reset()}.
	 * @return number of received notifications
	 */
	int getNumberOfNotifications();
	
	/**
	 * Returns all notified {@link Article}(s) per {@link Feed} since the creation of this {@link ManagebleFeedListener} 
	 * or the last {@link ManagebleFeedListener#reset()}.
	 * @return notified {@link Article}(s) per {@link Feed}
	 */
	Map<Feed<?,?,?,?,?,?>,Collection<Article<?,?,?,?,?>>> getNotifications();

}
