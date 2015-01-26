package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link MediumDTOImpl}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface MediumDAO extends DAO<MediumDTOImpl> {
	
	/**
	 * Finds a {@link MediumDTOImpl} by it's unique link.
	 * @param link the URL link location to look for
	 * @return the found {@link MediumDTOImpl} or <code>null</code> when not found
	 */
	MediumDTOImpl findByLink(final String link);

}
