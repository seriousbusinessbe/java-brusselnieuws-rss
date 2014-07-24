package be.seriousbusiness.brusselnieuws.rss.model;

import java.util.List;

import org.joda.time.DateTime;

/**
 * Represents an article published on a brusselnieuws.be feed.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Article extends Content {
	
	/**
	 * Get the number of authors who have written this article.
	 * @return the number of authors, zero if none
	 */
	int numberOfAuthors();
	
	/**
	 * Get the authors.
	 * @return a list of authors, empty when specified.
	 */
	List<Author> getAuthors();
	
	/**
	 * Check if this article is written or published by a given author.
	 * @param author the author to look for
	 * @return <code>true</code> when this article is written or published by the given author
	 */
	boolean hasAuthor(final Author author);
	
	/**
	 * Get the number of categories this article occurs in.
	 * @return the number of categories, zero if none
	 */
	int numberOfCategories();
	
	/**
	 * Check if this article is assigned to a given category. 
	 * @param category the category to look for
	 * @return <code>true</code> when this article is assigned to the given category
	 */
	boolean hasCategory(final Category category);
	
	/**
	 * Get the number of media attached to this article.
	 * @return the number of media, zero if none
	 */
	int numberOfMedia();
	
	/**
	 * Get the media (Videos, images, ...) attached to this article.
	 * @return a list of mediums, empty when none
	 */
	List<Medium> getMedia();
	
	/**
	 * Get the categories this article is in.
	 * @return a list of articles, empty when none
	 */
	List<Category> getCategories();
	
	/**
	 * Get the publication date.
	 * @return the publication date
	 */
	DateTime getPublicationDate();
	
	/**
	 * Check if this article is read or not.
	 * @return <code>true</code> when read
	 */
	boolean isRead();
	
	/**
	 * Mark this article read.
	 */
	void read();
	
	/**
	 * Check if this article is archived.
	 * @return< code>true</code> when archived
	 */
	boolean isArchived();
	
	/**
	 * Mark this article archived.
	 */
	void archive();

}
