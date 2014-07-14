package be.seriousbusiness.brusselnieuws.rss.model;

import java.util.Set;

/**
 * Represents a feed published by brusselnieuws.be
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Feed extends Content {
	
	/**
	 * Get the number of articles.
	 * @return number of articles
	 */
	int size();
	
	/**
	 * Get all articles published on this feed,</br>
	 * ordered by publication date.
	 * @return a set of articles, empty when none published
	 */
	Set<Article> getArticles();
	
	/**
	 * Get all articles by author.
	 * @param author the author to look for
	 * @return a set of articles, empty when none found
	 */
	Set<Article> getArticles(final Author author);
	
	/**
	 * Get all articles by category.
	 * @param category the category to look for
	 * @return a set of articles, empty when none found
	 */
	Set<Article> getArticles(final Category category);
}
