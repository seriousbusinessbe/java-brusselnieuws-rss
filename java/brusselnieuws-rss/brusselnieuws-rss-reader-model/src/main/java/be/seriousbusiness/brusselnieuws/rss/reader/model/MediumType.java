package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;

/**
 * Represents a unique medium type.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface MediumType extends Id<BigInteger>, Comparable<MediumType>, Cloneable {
	
	/**
	 * Gets the medium type.
	 * @return a <code>String</code> medium type or <code>null</code> when not set
	 */
	String getType();
	
	/**
	 * Sets the medium type.
	 * @param type the medium type
	 * @throws IllegalArgumentException when the type is <code>null</code> or empty
	 */
	void setType(final String type) throws IllegalArgumentException;

}
