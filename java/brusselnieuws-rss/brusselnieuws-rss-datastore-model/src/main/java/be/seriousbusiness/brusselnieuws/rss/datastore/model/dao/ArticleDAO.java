package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.List;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.ArticleDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link ArticleDTOImpl}.
 * @author stefanborghys
 *
 * @param <ARTICLEDTO> the type of {@link ArticleDTO} implementation
 */
public interface ArticleDAO extends IdDAO<BigInteger,ArticleDTOImpl> {
	
	/**
	 * Find all {@link ArticleDTOImpl} by title.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param title the title to look for
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByTitle(final String title);
	
	/**
	 * Find all {@link ArticleDTOImpl} published in a given period.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param from the start of the period
	 * @param to the end of the period
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByPublicationDateBetween(final DateTime from,final DateTime to);
	
	/**
	 * Find all {@link ArticleDTOImpl} marked read.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param read <code>true</code> to look for read, otherwise <code>false</code>
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByRead(final boolean read);
	
	/**
	 * Find all {@link ArticleDTOImpl} marked favorite.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param favorite <code>true</code> to look for favorite, otherwise <code>false</code>
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByFavorite(final boolean favorite);
	
	/**
	 * Find all {@link ArticleDTOImpl} marked archived.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param archived <code>true</code> to look for archived, otherwise <code>false</code>
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByArchived(final boolean archived);
	
	/**
	 * Find all {@link ArticleDTOImpl} by {@link CategoryDTOImpl}.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param categoryDTO the {@link CategoryDTOImpl} to look for
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByCategory(final CategoryDTOImpl categoryDTOImpl);
	
	/**
	 * Find all {@link ArticleDTOImpl} by {@link AuthorDTOImpl}.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param authorDTO the {@link AuthorDTOImpl} to look for
	 * @return a List of {@link ArticleDTOImpl}, empty when none found
	 */
	List<ArticleDTOImpl> findByAuthor(final AuthorDTOImpl authorDTOImpl);
	
}
