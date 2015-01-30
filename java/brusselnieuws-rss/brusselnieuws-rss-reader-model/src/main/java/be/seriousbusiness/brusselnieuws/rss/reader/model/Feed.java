package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;
import java.net.URL;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.reader.model.listener.FeedListenerManager;

/**
 * Represents a feed containing {@link Article}(s).
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <MEDIUMTYPE> the type of {@link MediumType} implementation
 * @param <MEDIUM> the type of {@link Medium} implementation
 * @param <CATEGORY> the type of {@link Category} implementation
 * @param <AUTHOR> the type of {@link Author} implementation
 * @param <ARTICLE> the type of {@link Article} implementation
 */
public interface Feed<MEDIUMTYPE extends MediumType,
						MEDIUM extends Medium<MEDIUMTYPE>,
						CATEGORY extends Category,
						AUTHOR extends Author,
						ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR>> extends Id<BigInteger>, FeedListenerManager {
	
	/**
	 * Gets this feed's title.
	 * @return the title
	 */
	String getTitle();
	
	/**
	 * Sets this feed's title.
	 * @param title a non <code>null</code> non empty title
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	void setTitle(final String title) throws IllegalArgumentException;
	
	/**
	 * Gets the {@link URL} link location.
	 * @return the {@link URL} link location
	 */
	URL getLink();
	
	/**
	 * Sets a {@link URL} link location.
	 * @param link the {@link URL} link location
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	void setLink(final URL link) throws IllegalArgumentException;
		
	/**
	 * Gets the description.
	 * @return the description
	 */
	String getDescription();
	
	/**
	 * Sets a description.</br>
	 * When <code>null</code> or empty no action is performed.
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Checks if a description is set.
	 * @return <code>true</code> when a description is set otherwise <code>false</code>
	 */
	boolean hasDescription();
	
	/**
	 * Gets the number of articles.
	 * @return number of articles
	 */
	int numberOfArticles();
	
	/**
	 * Gets a {@link Collection} of {@link ARTICLE}(s) published on this feed,</br>
	 * ordered by publication date from newest to oldest.
	 * @return a {@link Collection} of {@link ARTICLE}(s), empty when none published
	 */
	Collection<ARTICLE> getArticles();
	
	/**
	 * Set a {@link Collection} of {@link ARTICLE}(s).</br>
	 * <code>null</code> entries or already added {@link ARTICLE}(s) are not added.
	 * @param articles a {@link Collection} of {@link ARTICLE}(s)
	 */
	void setArticles(final Collection<ARTICLE> articles);
	
	/**
	 * Adds a unique non <code>null</code> {@link ARTICLE}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param article
	 */
	void add(final ARTICLE article);
	
	/**
	 * Checks if an {@link ARTICLE} is already added to this feed.
	 * @param article the {@link ARTICLE} to look for
	 * @return <code>true</code> when already added
	 */
	boolean hasArticle(final ARTICLE article);
	
	/**
	 * Gets a {@link Collection} of {@link ARTICLE}(s) by {@link AUTHOR},</br>
	 * ordered by publication date from newest to oldest.
	 * @param author the {@link Author} to look for
	 * @return a {@link Collection} of {@link ARTICLE}(s), empty when none found
	 */
	Collection<ARTICLE> getArticles(final AUTHOR author);
	
	/**
	 * Gets a {@link Collection} of {@link ARTICLE}(s) by {@link CATEGORY},</br>
	 * ordered by publication date from newest to oldest.
	 * @param category the {@link CATEGORY} to look for
	 * @return a {@link Collection} of {@link ARTICLE}(s), empty when none found
	 */
	Collection<ARTICLE> getArticles(final CATEGORY category);
	
	/**
	 * Gets a {@link Collection} of {@link ARTICLE} marked archived or not,</br>
	 * ordered by publication date from newest to oldest.
	 * @param archived <code>true</code> when looking for all archived articles
	 * @return a {@link Collection} of {@link ARTICLE}, empty when none found
	 */
	Collection<ARTICLE> getArticles(final boolean archived);	
	
}
