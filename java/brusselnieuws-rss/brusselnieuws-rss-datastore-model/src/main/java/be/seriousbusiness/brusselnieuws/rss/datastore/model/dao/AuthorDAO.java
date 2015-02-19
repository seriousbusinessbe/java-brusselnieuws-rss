package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link AuthorDTOImpl}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface AuthorDAO extends IdDAO<BigInteger,AuthorDTOImpl> {
	
	/**
	 * Finds all {@link AuthorDTOImpl} by name.
	 * @param name the author name to look for
	 * @return a {@link Collection} of {@link AuthorDTOImpl}, empty when none found
	 */
	Collection<AuthorDTOImpl> findByName(final String name);
	
	/**
	 * Finds the first {@link AuthorDTOImpl} by name.
	 * @param name the author name to look for
	 * @return the found {@link MongoAuthor} <code>null</code> when not found
	 */
	AuthorDTOImpl findFirstByName(final String name);

}
