package be.seriousbusiness.brusselnieuws.rss.model.builder;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;

/**
 * Defines a Feed builder.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface FeedBuilder extends ContentBuilder<Feed> {
	
	/**
	 * Add an article.</br>
	 * Nothing happens when <code>null</code> or already added.
	 * @param article
	 * @return this FeedBuilder
	 */
	FeedBuilder add(final Article article);
	
}
