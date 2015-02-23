package be.seriousbusiness.brusselnieuws.rss.reader.model.manager;

import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Creator;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;

/**
 * Manage {@link Article}.
 * @author stefanborghys
 *
 */
public interface ArticleManager<MEDIUMTYPE extends MediumType,
								MEDIUM extends Medium<MEDIUMTYPE>,
								CATEGORY extends Category,
								AUTHOR extends Author,
								CREATOR extends Creator,
								ARTICLE extends Article<MEDIUMTYPE,MEDIUM,CATEGORY,AUTHOR,CREATOR>> {
	
	/**
	 * Find all {@link Article} ordered by publication date.
	 * @return a {@link Collection} of {@link Article}, empty when none found
	 */
	Collection<ARTICLE> findAll();

}
