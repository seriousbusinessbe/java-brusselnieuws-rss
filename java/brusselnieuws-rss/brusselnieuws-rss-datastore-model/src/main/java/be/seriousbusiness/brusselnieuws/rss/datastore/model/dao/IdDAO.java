package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * Describes an extended DAO (Data Access Object) for handling {@link IdDTO}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ID> the type of id
 * @param <IDDTO> a type of {@link IdDTO} implementation
 */
public interface IdDAO<ID,IDDTO extends IdDTO<ID>> extends DAO<IDDTO> {
	
	/**
	 * Finds a {@link IDDTO} by a unique identifier.
	 * @param id the identifier to look for.
	 * @return the found {@link IDDTO} or <code>null</code> when not found
	 */
	IDDTO findById(final ID id);

}
