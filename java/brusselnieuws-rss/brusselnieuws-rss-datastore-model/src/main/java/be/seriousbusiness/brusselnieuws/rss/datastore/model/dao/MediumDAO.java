package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link MediumDTOImpl}.
 * @author stefanborghys
 * 
 */
public interface MediumDAO extends DAO<MediumDTOImpl> {
	
	/**
	 * Find a {@link MediumDTOImpl} by it's unique link.
	 * @param link to link to look for
	 * @return the found {@link MediumDTOImpl} or <code>null</code> when not found
	 */
	MediumDTOImpl findByLink(final String link);

}
