package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import org.joda.time.DateTime;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.ArticleDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * Describes a DAO (Data Access Object) which is specific for handling {@link ArticleDAO}.
 * @author stefanborghys
 *
 */
public interface ArticleDAO extends IdDAO<Long,ArticleDTO> {
	
	/**
	 * Find all {@link ArticleDTO} by title.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param title the title to look for
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findByTitle(final String title);
	
	/**
	 * Find all {@link ArticleDTO} published in a given period.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param from the start of the period
	 * @param to the end of the period
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findBetweenPublicationDates(final DateTime from,final DateTime to);
	
	/**
	 * Find all {@link ArticleDTO} marked read.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param read <code>true</code> to look for read, otherwise <code>false</code>
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findByRead(final boolean read);
	
	/**
	 * Find all {@link ArticleDTO} marked favorite.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param favorite <code>true</code> to look for favorite, otherwise <code>false</code>
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findByFavorite(final boolean favorite);
	
	/**
	 * Find all {@link ArticleDTO} marked archived.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param archived <code>true</code> to look for archived, otherwise <code>false</code>
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findByArchived(final boolean archived);
	
	/**
	 * Find all {@link ArticleDTO} by {@link CategoryDTO}.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param categoryDTO the {@link CategoryDTO} to look for
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findByCategory(final CategoryDTO categoryDTO);
	
	/**
	 * Find all {@link ArticleDTO} by {@link AuthorDTO}.</br>
	 * Ordered by publication date from most recent to oldest.
	 * @param authorDTO the {@link AuthorDTO} to look for
	 * @return a List of {@link ArticleDTO}, empty when none found
	 */
	List<ArticleDTO> findByAuthor(final AuthorDTO authorDTO);
	
}
