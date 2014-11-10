package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * Describes an extended DAO (Data Access Object),</br>
 * specific for handling {@link IdDTO} (Data Transfer Object).
 * @author stefanborghys
 *
 * @param <ID> the type of id
 * @param <IDDTO> a type of {@link IdDTO} implementation
 */
public interface IdDAO<ID,IDDTO extends IdDTO<ID>> extends DAO<IDDTO> {
	
	/**
	 * Retrieve a {@link IDDTO} by unique identifier.
	 * @param id the identifier to look for.
	 * @return the found {@link IDDTO} or <code>null</code> when not found
	 */
	IDDTO findById(final ID id);

}
