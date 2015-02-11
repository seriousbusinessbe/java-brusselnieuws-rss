package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.Collection;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link ArticleDTOImpl}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ARTICLEDTO> the type of {@link ArticleDTO} implementation
 */
public interface ArticleDAO extends IdDAO<BigInteger,ArticleDTOImpl> {
	
	/**
	 * Finds all {@link ArticleDTOImpl} by title.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param title the article title to look for
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByTitle(final String title);
	
	/**
	 * Finds all {@link ArticleDTOImpl} published in a given period.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param from the start of the period
	 * @param to the end of the period
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByPublicationDateBetween(final DateTime from,final DateTime to);
	
	/**
	 * Finds all {@link ArticleDTOImpl} marked read.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param read <code>true</code> to look for read articles, <code>false</code> for non-read articles
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByRead(final boolean read);
	
	/**
	 * Finds all {@link ArticleDTOImpl} marked favorite.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param favorite <code>true</code> to look for favorite articles, <code>false</code> for non-favorite articles
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByFavorite(final boolean favorite);
	
	/**
	 * Finds all {@link ArticleDTOImpl} marked archived.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param archived <code>true</code> to look for archived articles, <code>false</code> for non-archived articles
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByArchived(final boolean archived);
	
	/**
	 * Find all {@link ArticleDTOImpl} by {@link CategoryDTOImpl}.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param categoryDTO the {@link CategoryDTOImpl} to look for
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByCategory(final CategoryDTOImpl categoryDTOImpl);
	
	/**
	 * Finds all {@link ArticleDTOImpl} by {@link AuthorDTOImpl}.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param authorDTO the {@link AuthorDTOImpl} to look for
	 * @return a {@link Collection} of {@link ArticleDTOImpl}, empty when none found
	 */
	Collection<ArticleDTOImpl> findByAuthor(final AuthorDTOImpl authorDTOImpl);
	
	/**
	 * Finds a {@link ArticleDTOImpl} by title and publication date.
	 * @param title the article's title 
	 * @param publicationDate the article's publication date
	 * @return the found {@link ArticleDTOImpl} or <code>null</code> when not found
	 */
	ArticleDTOImpl findByTitleAndPublicationDate(final String title,final DateTime publicationDate);
	
}
