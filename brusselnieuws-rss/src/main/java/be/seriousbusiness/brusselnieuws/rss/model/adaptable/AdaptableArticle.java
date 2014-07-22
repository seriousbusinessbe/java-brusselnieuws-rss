package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

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
public interface AdaptableArticle extends Article, AdaptableContent {
	
	/**
	 * Add a new author.</br>
	 * No action is performed if the author is <code>null</code> or already added.
	 * @param author
	 */
	void add(final Author author);
	
	/**
	 * Add a new Media.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	void add(final Medium medium);
	
	/**
	 * Add a new Category.</br>
	 * No action is performed when <code<null</code>
	 * @param author
	 */
	void add(final Category category);

}
