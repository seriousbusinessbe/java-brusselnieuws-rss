package be.seriousbusiness.brusselnieuws.rss.reader.model.manager;

import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;

/**
 * Manage {@link Author}.
 * @author stefanborghys
 *
 */
public interface AuthorManager {
	
	/**
	 * Find all {@link Author} ordered by name.
	 * @return a {@link Collection} of {@link Author}, empty when none found
	 */
	Collection<Author> findAll();

}
