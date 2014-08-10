package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link MediumTypeDTO}.
 * @author stefanborghys
 * @param <DTO> the type of {@link MediumTypeDTO}
 */
public interface MediumTypeDAO<DTO extends MediumTypeDTO> extends IdDAO<Long,DTO> {
	
	/**
	 * Find a {@link MediumTypeDTO} by type.
	 * @param type the type to look for
	 * @return a {@link MediumTypeDTO} if found, otherwise <code>null</code>
	 */
	MediumTypeDTO findByType(final String type);

}
