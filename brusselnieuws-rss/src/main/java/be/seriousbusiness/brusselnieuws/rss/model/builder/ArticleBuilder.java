package be.seriousbusiness.brusselnieuws.rss.model.builder;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Media;

/**
 * Defines an Article builder.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface ArticleBuilder extends ContentBuilder<Article> {
	
	/**
	 * Add an author.</br>
	 * Nothing happens when <code>null</code> or already added.
	 * @param author
	 * @return this ArticleBuilder
	 */
	ArticleBuilder add(final Author author);
	
	/**
	 * Add a category.</br>
	 * Nothing happens when <code>null</code> or already added.
	 * @param category
	 * @return this ArticleBuilder
	 */
	ArticleBuilder add(final Category category);
	
	/**
	 * Add media.</br>
	 * Nothing happens when <code>null</code> or already added.
	 * @param media
	 * @return this ArticleBuilder
	 */
	ArticleBuilder add(final Media media);
	
	/**
	 * Set a publication date.
	 * @param publicationDate
	 * @return this ArticleBuilder
	 */
	ArticleBuilder publicationDate(final DateTime publicationDate);

}
