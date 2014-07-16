package be.seriousbusiness.brusselnieuws.rss.model;

import java.util.Set;

import org.joda.time.DateTime;

/**
 * Represents an article published on a brusselnieuws.be feed.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Article extends Content {
	
	/**
	 * Get the authors.
	 * @return a set of authors, empty when specified.
	 */
	Set<Author> getAuthors();
	
	/**
	 * Check if this article is written or published by a given author.
	 * @param author the author to look for
	 * @return <code>true</code> when this article is written or published by the given author
	 */
	boolean hasAuthor(final Author author);
	
	/**
	 * Check if this article is assigned to a given category. 
	 * @param category the category to look for
	 * @return <code>true</code> when this article is assigned to the given category
	 */
	boolean hasCategory(final Category category);
	
	/**
	 * Get the media (Videos, images, ...) attached to this article.
	 * @return a set of mediums, empty when none
	 */
	Set<Medium> getMedia();
	
	/**
	 * Get the categories this article is in.
	 * @return a set of articles, empty when none
	 */
	Set<Category> getCategories();
	
	/**
	 * Get the publication date.
	 * @return the publication date
	 */
	DateTime getPublicationDate();

}
