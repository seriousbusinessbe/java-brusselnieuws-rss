package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link AuthorDTOImpl}.
 * @author stefanborghys
 *
 */
public interface AuthorDAO extends IdDAO<BigInteger,AuthorDTOImpl> {
	
	/**
	 * Find all {@link AuthorDTOImpl} by name.
	 * @param name the name to look for
	 * @return a List of {@link AuthorDTOImpl}, empty when none found
	 */
	List<AuthorDTOImpl> findByName(final String name);

}
