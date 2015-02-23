package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;

/**
 * Represents a DTO (data transfer object) responsible for creator information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface CreatorDTO extends IdDTO<BigInteger>, Cloneable {
	
	/**
	 * Gets the name.
	 * @return the creator name or <code>null</code> when not set
	 */
	String getName();
	
	/**
	 * Sets the name.
	 * @param name
	 */
	void setName(final String name);

}
