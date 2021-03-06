package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;
import java.util.Collection;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link CategoryDTO}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface CategoryDAO extends IdDAO<BigInteger,CategoryDTOImpl> {
	
	/**
	 * Finds all {@link CategoryDTOImpl} by name.
	 * @param name the categorie's name to look for
	 * @return a {@link Collection} of {@link CategoryDTOImpl}, empty when none found
	 */
	Collection<CategoryDTOImpl> findByName(final String name);
	
	/**
	 * Finds a {@link CategoryDTOImpl} by it's unique link.
	 * @param link the category URL location link to look for
	 * @return the {@link CategoryDTOImpl} or <code>null</code> when not found
	 */
	CategoryDTOImpl findByLink(final String link);

}
