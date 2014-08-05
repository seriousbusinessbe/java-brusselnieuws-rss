package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * Describes a DAO (Data Access Object) which is specific for handling {@link CategoryDTO}.
 * @author stefanborghys
 *
 */
public interface CategoryDAO extends IdDAO<Long,CategoryDTO> {
	
	/**
	 * Find all {@link CategoryDTO} by name
	 * @param name the name to look for
	 * @return a list of {@link CategoryDTO}, empty when none found
	 */
	List<CategoryDTO> findByName(final String name);
	
	/**
	 * Find a {@link CategoryDTO} by it's unique link.
	 * @param link the link to look for
	 * @return the {@link CategoryDTO} or <code>null</code> when not found
	 */
	CategoryDTO findByLink(final String link);

}
