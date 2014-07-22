package be.seriousbusiness.brusselnieuws.rss.model;

import java.util.List;

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
	 * @return a list of articles, empty when none published
	 */
	List<Article> getArticles();
	
	/**
	 * Check if an article is added to this feed.
	 * @param article the article to look for
	 * @return <code>true</code>
	 */
	boolean hasArticle(final Article article);
	
	/**
	 * Get all articles by author.
	 * @param author the author to look for
	 * @return a list of articles, empty when none found
	 */
	List<Article> getArticles(final Author author);
	
	/**
	 * Get all articles by category.
	 * @param category the category to look for
	 * @return a list of articles, empty when none found
	 */
	List<Article> getArticles(final Category category);
}
