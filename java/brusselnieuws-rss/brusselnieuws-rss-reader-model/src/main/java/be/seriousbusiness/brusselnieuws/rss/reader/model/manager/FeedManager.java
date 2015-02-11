package be.seriousbusiness.brusselnieuws.rss.reader.model.manager;

import java.net.URL;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

/**
 * Manage {@link Feed}.
 * @author stefanborghys
 */
public interface FeedManager<MEDIUMTYPE extends MediumType,
							 MEDIUM extends Medium<MEDIUMTYPE>,
							 CATEGORY extends Category,
							 AUTHOR extends Author,
							 ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR>,
							 FEED extends Feed<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,ARTICLE>> {
	
	/**
	 * Find all {@link Feed} ordered by name.
	 * @return a {@link Collection} of {@link Feed}, empty when none found
	 */
	Collection<FEED> findAll();
	
	/**
	 * Find a {@link Feed} by it's link.
	 * @param url
	 * @return the corresponding {@link Feed} or <code>null</code> when not found
	 */
	FEED findByLink(final URL url);
	
	/**
	 * Save a {@link Feed} and all of it's {@link Article}.</br>
	 * Use the returned instance for further operations</br>
	 * as the save operation might have changed the entity instance completely.
	 * @param feed
	 * @return the saved {@link Feed}
	 */
	FEED save(final FEED feed);

}
