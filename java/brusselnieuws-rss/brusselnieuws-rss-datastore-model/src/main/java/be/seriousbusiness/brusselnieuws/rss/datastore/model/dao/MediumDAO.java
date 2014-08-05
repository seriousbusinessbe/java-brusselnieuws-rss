package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

/**
 * Describes a DAO (Data Access Object) which is specific for handling {@link MediumDTO}.
 * @author stefanborghys
 *
 */
public interface MediumDAO extends DAO<MediumDTO> {
	
	/**
	 * Find a {@link MediumDTO} by it's unique link.
	 * @param link to link to look for
	 * @return the found {@link MediumDTO} or <code>null</code> when not found
	 */
	MediumDTO findByLink(final String link);

}
