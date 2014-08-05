package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * Describes a DAO (Data Access Object) which is specific for handling {@link AuthorDTO}.
 * @author stefanborghys
 *
 */
public interface AuthorDAO extends IdDAO<Long,AuthorDTO> {
	
	/**
	 * Find all {@link AuthorDTO} by name.
	 * @param name the name to look for
	 * @return a List of {@link AuthorDTO}, empty when none found
	 */
	List<AuthorDTO> findByName(final String name);

}
