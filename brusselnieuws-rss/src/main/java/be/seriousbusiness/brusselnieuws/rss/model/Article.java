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
	 * Get the media (Videos, images, ...) attached to this article.
	 * @return a set of media, empty when none
	 */
	Set<Media> getMedia();
	
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
