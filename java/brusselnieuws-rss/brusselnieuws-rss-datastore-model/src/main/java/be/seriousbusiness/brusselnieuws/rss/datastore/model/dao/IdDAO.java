package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * Describes an extended DAO (Data Access Object).</br>
 * Capable of handling {@link IdDTO} (Data Transfer Object).
 * @author stefanborghys
 *
 * @param <ID> the type of id
 * @param <DTO> a type of {@link IdDTO} implementation
 */
public interface IdDAO<ID,DTO extends IdDTO<ID>> extends DAO<DTO> {
	
	/**
	 * Retrieve a {@link DTO} by unique identifier.
	 * @param id the identifier to look for.
	 * @return the found {@link DTO} or <code>null</code> when not found
	 */
	DTO findById(final ID id);

}
