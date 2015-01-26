package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;

/**
 * Describes a DAO (Data Access Object) for handling {@link MediumTypeDTOImpl}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface MediumTypeDAO extends IdDAO<BigInteger,MediumTypeDTOImpl> {
	
	/**
	 * Finds {@link MediumTypeDTOImpl} by type.
	 * @param type the type of medium to look for
	 * @return a {@link MediumTypeDTOImpl} if found otherwise <code>null</code>
	 */
	MediumTypeDTOImpl findByType(final String type);

}
