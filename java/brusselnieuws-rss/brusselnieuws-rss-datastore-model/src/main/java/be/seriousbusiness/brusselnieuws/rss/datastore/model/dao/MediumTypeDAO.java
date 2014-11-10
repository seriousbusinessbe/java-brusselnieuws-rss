package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;

/**
 * Describes a DAO (Data Access Object), specific for handling {@link MediumTypeDTOImpl}.
 * @author stefanborghys
 * 
 */
public interface MediumTypeDAO extends IdDAO<BigInteger,MediumTypeDTOImpl> {
	
	/**
	 * Find a {@link MediumTypeDTOImpl} by type.
	 * @param type the type to look for
	 * @return a {@link MediumTypeDTOImpl} if found, otherwise <code>null</code>
	 */
	MediumTypeDTOImpl findByType(final String type);

}
