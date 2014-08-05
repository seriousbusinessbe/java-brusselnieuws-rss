package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

/**
 * Describes a DAO (Data Access Object) which is specific for handling {@link MediumTypeDTO}.
 * @author stefanborghys
 *
 */
public interface MediumTypeDAO extends IdDAO<Long,MediumTypeDTO> {
	
	/**
	 * Find a {@link MediumTypeDTO} by type.
	 * @param type the type to look for
	 * @return a {@link MediumTypeDTO} if found, otherwise <code>null</code>
	 */
	MediumTypeDTO findByType(final String type);

}
