package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link CreatorDTOImpl}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface CreatorDAO extends IdDAO<BigInteger,CreatorDTOImpl> {
	
	/**
	 * Finds all {@link CreatorDTOImpl} by name.
	 * @param name the creator name to look for
	 * @return a {@link Collection} of {@link CreatorDTOImpl}, empty when none found
	 */
	Collection<CreatorDTOImpl> findByName(final String name);
	
	/**
	 * Finds the first {@link CreatorDTOImpl} by name.
	 * @param name the creator name to look for
	 * @return the found {@link MongoCreator} <code>null</code> when not found
	 */
	CreatorDTOImpl findFirstByName(final String name);

}
