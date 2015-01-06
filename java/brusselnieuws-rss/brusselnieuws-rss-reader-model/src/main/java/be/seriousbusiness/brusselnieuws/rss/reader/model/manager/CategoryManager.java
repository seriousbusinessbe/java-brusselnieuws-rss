package be.seriousbusiness.brusselnieuws.rss.reader.model.manager;

import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;

/**
 * Manage {@link Category}.
 * @author stefanborghys
 */
public interface CategoryManager {
	
	/**
	 * Find all {@link Category} ordered by name.
	 * @return a {@link Collection} of {@link Category}, empty when none found
	 */
	Collection<Category> findAll();

}
