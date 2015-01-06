package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;
import java.net.URL;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.reader.model.listener.FeedListenerManager;

/**
 * Represents a {@link Feed} containing {@link Article}.
 * @author Stefan Borghys
 * @author Serious Business
 * 
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
	 * Get the title.
	 * @return the title
	 */
	String getTitle();
	
	/**
	 * Set a title.
	 * @param title
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	void setTitle(final String title) throws IllegalArgumentException;
	
	/**
	 * Get the web {@link URL}.
	 * @return the web {@link URL}
	 */
	URL getLink();
	
	/**
	 * Set a web {@link URL}.
	 * @param link
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	void setLink(final URL link) throws IllegalArgumentException;
		
	/**
	 * Get the description.
	 * @return the description
	 */
	String getDescription();
	
	/**
	 * Set a description.</br>
	 * When <code>null</code> or empty no action is performed.
	 * @param description
	 */
	void setDescription(final String description);
	
	/**
	 * Check if a description is set.
	 * @return <code>true</code> when a description is set
	 */
	boolean hasDescription();
	
	/**
	 * Get the number of articles.
	 * @return number of articles
	 */
	int numberOfArticles();
	
	/**
	 * Get a {@link Collection} of {@link ARTICLE} published on this feed,</br>
	 * ordered by publication date from newest to oldest.
	 * @return a {@link Collection} of {@link ARTICLE}, empty when none published
	 */
	Collection<ARTICLE> getArticles();
	
	/**
	 * Set a {@link Collection} of {@link ARTICLE}.</br>
	 * <code>null</code> entries are not added.</br>
	 * Already added {@link ARTICLE} are also not added.
	 * @param articles
	 */
	void setArticles(final Collection<ARTICLE> articles);
	
	/**
	 * Add a unique, not <code>null</code> {@link ARTICLE}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param article
	 */
	void add(final ARTICLE article);
	
	/**
	 * Check if an {@link ARTICLE} is already added to this feed.
	 * @param article the {@link ARTICLE} to look for
	 * @return <code>true</code> when already added
	 */
	boolean hasArticle(final ARTICLE article);
	
	/**
	 * Get a {@link Collection} of {@link ARTICLE} by {@link AUTHOR},</br>
	 * ordered by publication date from newest to oldest.
	 * @param author the {@link Author} to look for
	 * @return a {@link Collection} of {@link ARTICLE}, empty when none found
	 */
	Collection<ARTICLE> getArticles(final AUTHOR author);
	
	/**
	 * Get a {@link Collection} of {@link ARTICLE} by {@link CATEGORY},</br>
	 * ordered by publication date from newest to oldest.
	 * @param category the {@link CATEGORY} to look for
	 * @return a {@link Collection} of {@link ARTICLE}, empty when none found
	 */
	Collection<ARTICLE> getArticles(final CATEGORY category);
	
	/**
	 * Get a {@link Collection} of {@link ARTICLE} marked archived or not,</br>
	 * ordered by publication date from newest to oldest.
	 * @param archived <code>true</code> when looking for all archived articles
	 * @return a {@link Collection} of {@link ARTICLE}, empty when none found
	 */
	Collection<ARTICLE> getArticles(final boolean archived);	
	
}
