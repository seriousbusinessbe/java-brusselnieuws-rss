package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.List;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link CategoryDTO}.
 * @author stefanborghys
 * 
 */
public interface CategoryDAO extends IdDAO<BigInteger,CategoryDTOImpl> {
	
	/**
	 * Find all {@link CategoryDTOImpl} by name
	 * @param name the name to look for
	 * @return a list of {@link CategoryDTOImpl}, empty when none found
	 */
	List<CategoryDTOImpl> findByName(final String name);
	
	/**
	 * Find a {@link CategoryDTOImpl} by it's unique link.
	 * @param link the link to look for
	 * @return the {@link CategoryDTOImpl} or <code>null</code> when not found
	 */
	CategoryDTOImpl findByLink(final String link);

}
