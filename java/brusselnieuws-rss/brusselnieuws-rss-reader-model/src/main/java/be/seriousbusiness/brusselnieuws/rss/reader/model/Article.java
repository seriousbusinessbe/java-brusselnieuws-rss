package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;
import java.net.URL;
import java.util.Collection;

import org.joda.time.DateTime;

/**
 * Represents an article published on a {@link Feed}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <MEDIUMTYPE> the type of {@link MediumType} implementation
 * @param <MEDIUM> the type of {@link Medium} implementation
 * @param <CATEGORY> the type of {@link Category} implementation
 * @param <AUTHOR> the type of {@link Author} implementation
 * @param <CREATOR> the type of {@link Creator} implementation
 */
public interface Article<MEDIUMTYPE extends MediumType,
						MEDIUM extends Medium<MEDIUMTYPE>,
						CATEGORY extends Category,
						AUTHOR extends Author,
						CREATOR extends Creator> extends Id<BigInteger>, Cloneable {
	
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
	 * Set a description.
	 * @param description
	 * @throws IllegalArgumentException when <code>null</code> or empty.
	 */
	void setDescription(final String description) throws IllegalArgumentException;
	
	/**
	 * Check if a description is set.
	 * @return <code>true</code> when a description is set
	 */
	boolean hasDescription();
	
	/**
	 * Get the number of {@link Author} who wrote this article.
	 * @return the number of authors, 0 if none
	 */
	int numberOfAuthors();
	
	/**
	 * Get the authors.
	 * @return the {@link Collection} of {@link AUTHOR} who wrote this article, empty when none
	 */
	Collection<AUTHOR> getAuthors();
	
	/**
	 * Set a {@link Collection} of {@link AUTHOR}.</br>
	 * <code>null</code> entries are not added.</br>
	 * Already added {@link AUTHOR} are also not added.
	 * @param authors
	 */
	void setAuthors(final Collection<AUTHOR> authors);
	
	/**
	 * Add a unique, not <code>null</code> {@link AUTHOR}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param author
	 */
	void add(final AUTHOR author);
	
	/**
	 * Check if this {@link Article} is written by a specific {@link AUTHOR}.
	 * @param author the {@link AUTHOR} to look for
	 * @return <code>true</code> when this {@link Article} is written by a given {@link AUTHOR}
	 */
	boolean hasAuthor(final AUTHOR author);
	
	/**
	 * Get the number of {@link CATEGORY} this {@link Article} occurs in.
	 * @return the number of {@link CATEGORY}, 0 if none
	 */
	int numberOfCategories();
	
	/**
	 * Get the {@link Collection} of {@link CATEGORY} this {@link Article} is in.
	 * @return the {@link Collection} of {@link CATEGORY}, empty when none
	 */
	Collection<CATEGORY> getCategories();
	
	/**
	 * Set a {@link Collection} of {@link CATEGORY}.</br>
	 * <code>null</code> entries are not added.</br>
	 * Already added {@link CATEGORY} are also not added.
	 * @param categories
	 */
	void setCategories(final Collection<CATEGORY> categories);
	
	/**
	 * Add a unique, not <code>null</code> {@link CATEGORY}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param category
	 */
	void add(final CATEGORY category);
	
	/**
	 * Check if this {@link Article} is in a specific {@link CATEGORY}.
	 * @param category the {@link CATEGORY} to look for
	 * @return <code>true</code> when this {@link Article} is in a given {@link CATEGORY}
	 */
	boolean hasCategory(final CATEGORY category);
	
	/**
	 * Get the number of {@link MEDIUM} attached to this {@link Article}.
	 * @return the number of {@link MEDIUM}, 0 if none
	 */
	int numberOfMedia();
	
	/**
	 * Get a {@link Collection} of {@link MEDIUM} (Video(s), image(s), ...) attached to this {@link Article}.
	 * @return a {@link Collection} of {@link MEDIUM}, empty when none
	 */
	Collection<MEDIUM> getMedia();
	
	/**
	 * Set a {@link Collection} of {@link MEDIUM}.</br>
	 * <code>null</code> entries are not added.</br>
	 * Already added {@link MEDIUM} are also not added.
	 * @param media
	 */
	void setMedia(final Collection<MEDIUM> media);
	
	/**
	 * Add a unique, not <code>null</code> {@link MEDIUM}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param category
	 */
	void add(final MEDIUM medium);
	
	/**
	 * Get the number of {@link Creator}(s) who created this article.
	 * @return the number of creators, 0 if none
	 */
	int numberOfCreators();
	
	/**
	 * Get the creators.
	 * @return the {@link Collection} of {@link CREATOR} who created this article, empty when none
	 */
	Collection<CREATOR> getCreators();
	
	/**
	 * Set a {@link Collection} of {@link CREATOR}.</br>
	 * <code>null</code> entries are not added.</br>
	 * Already added {@link CREATOR} are also not added.
	 * @param creators
	 */
	void setCreators(final Collection<CREATOR> creators);
	
	/**
	 * Add a unique, not <code>null</code> {@link CREATOR}.</br>
	 * Not added when <code>null</code> or already added.
	 * @param creator
	 */
	void add(final CREATOR creator);
	
	/**
	 * Check if this {@link Article} is written by a specific {@link CREATOR}.
	 * @param creator the {@link CREATOR} to look for
	 * @return <code>true</code> when this {@link Article} is created by a given {@link CREATOR}
	 */
	boolean hasCreator(final CREATOR creator);
	
	/**
	 * Get the publication date.
	 * @return the publication date
	 */
	DateTime getPublicationDate();
	
	/**
	 * Set a publication {@link DateTime}
	 * @param publicationDate
	 * @throws IllegalArgumentException when <code>null</code> or in the future
	 */
	void setPublicationDate(final DateTime publicationDate) throws IllegalArgumentException;
	
	/**
	 * Check if this {@link Article} is read or not.
	 * @return <code>true</code> when read
	 */
	boolean isRead();
	
	/**
	 * Mark this {@link Article} read or not.
	 * @param read <code>true</code> when read,
	 * otherwise <code>false</code>
	 */
	void setRead(final boolean read);
	
	/**
	 * Mark this {@link Article} as read.
	 */
	void read();
	
	/**
	 * Check if this {@link Article} is archived.
	 * @return< code>true</code> when archived
	 */
	boolean isArchived();
	
	/**
	 * Mart this {@link Article} archived or not.
	 * @param archived <code>true</code> when archived,
	 * otherwise <code>false</code>
	 */
	void setArchived(final boolean archived);
	
	/**
	 * Mark this {@link Article} as archived.
	 */
	void archive();
	
	/**
	 * Check if this {@link Article) is marked as favorite.
	 * @return <code>true</code> when a favorite
	 */
	boolean isFavorite();
	
	/**
	 * Mark this {@link Article} as favorite.
	 * @param favorite <code>true</code> when favorite,
	 * otherwise <code>false</code>
	 */
	void setFavorite(final boolean favorite);
	
	/**
	 * Mark this {@link Article} as favorite.
	 */
	void favorite();
	
}
