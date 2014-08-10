package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link CategoryDTO}.
 * @author stefanborghys
 * @param <DTO> the type of {@link CategoryDTO}
 */
public interface CategoryDAO<DTO extends CategoryDTO> extends IdDAO<Long,DTO> {
	
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
