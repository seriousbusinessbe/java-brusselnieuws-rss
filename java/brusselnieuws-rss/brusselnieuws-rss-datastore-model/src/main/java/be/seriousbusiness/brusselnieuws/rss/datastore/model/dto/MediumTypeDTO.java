package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;

/**
 * Represents a DTO (data transfer object) responsible for medium type information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface MediumTypeDTO extends IdDTO<BigInteger> {
	
	/**
	 * Gets the medium type representation.
	 * @return a <code>String</code> medium type representation or <code>null</code> when not set
	 */
	String getType();
	
	/**
	 * Sets the medium type representation.
	 * @param type <code>String</code> medium type representation
	 */
	void setType(final String type);

}
