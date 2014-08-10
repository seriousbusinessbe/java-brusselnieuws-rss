package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link AuthorDTO}.
 * @author stefanborghys
 * @param <DTO> the type of {@link AuthorDTO}
 */
public interface AuthorDAO<DTO extends AuthorDTO> extends IdDAO<Long,DTO> {
	
	/**
	 * Find all {@link AuthorDTO} by name.
	 * @param name the name to look for
	 * @return a List of {@link AuthorDTO}, empty when none found
	 */
	List<AuthorDTO> findByName(final String name);

}
