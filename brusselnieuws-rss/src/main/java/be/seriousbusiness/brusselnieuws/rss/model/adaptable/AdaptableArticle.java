package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import java.util.List;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;

/**
 * Represents an article published on a brusselnieuws.be feed</br>
 * capable of being altered
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface AdaptableArticle extends Article, AdaptableContent<Long> {
	
	/**
	 * Add a new author.</br>
	 * No action is performed if the author is <code>null</code> or already added.
	 * @param author
	 */
	void add(final Author author);
	
	/**
	 * Set a new Set of authors.
	 * This method is solely introduced for the Dozer mappings.</br>
	 * Preferably use the add() method defined by above.</br>
	 * No action is performed when the list of authors is <code>null</code> or empty.
	 * @param authors 
	 */
	void setAuthors(final List<Author> authors);
	
	/**
	 * Add a new Media.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	void add(final Medium medium);
	
	/**
	 * Set a new Set of mediums.
	 * This method is solely introduced for the Dozer mappings.</br>
	 * Preferably use the add() method defined by above.</br>
	 * No action is performed when the list of mediums is <code>null</code> or empty.
	 * @param media
	 */
	void setMedia(final List<Medium> media);
	
	/**
	 * Add a new Category.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	void add(final Category category);
	
	/**
	 * Set a new Set of categories.
	 * This method is solely introduced for the Dozer mappings.</br>
	 * Preferably use the add() method defined by above.</br>
	 * No action is performed when the list of categories is <code>null</code> or empty.
	 * @param categories
	 */
	void setCategories(final List<Category> categories);
		
	/**
	 * Set a publication date.
	 * @param publicationDate
	 * @throws IllegalArgumentException when <code>null</code> or in the future
	 */
	void setPublicationDate(final DateTime publicationDate) throws IllegalArgumentException;
	
	/**
	 * Set this article archived.</br>
	 * This method is solely introduced for the Dozer mappings.</br>
	 * Preferably use the archive() method defined by Article.
	 * @param archived
	 */
	void setArchived(final boolean archived);
	
	/**
	 * Set this article read.</br>
	 * This method is solely introduced for the Dozer mappings.</br>
	 * Preferably use the read() method defined by Article.
	 * @param read
	 */
	void setRead(final boolean read);

}
