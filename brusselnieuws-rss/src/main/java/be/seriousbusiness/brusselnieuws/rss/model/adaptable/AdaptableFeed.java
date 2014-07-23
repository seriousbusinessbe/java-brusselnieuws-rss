package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;

/**
 * Represents a feed published by brusselnieuws.be,</br>
 * capable of being altered 
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface AdaptableFeed extends Feed, AdaptableContent {
	
	/**
	 * Add a new article.</br>
	 * No action is performed when the article is <code>null</code> or already added.
	 * @param article
	 */
	void add(final Article article);

}