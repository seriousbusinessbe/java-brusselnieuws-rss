package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;

/**
 * Represents a unique medium type.
 * @author stefanborghys
 *
 */
public interface MediumType extends Id<BigInteger>, Comparable<MediumType> {
	
	/**
	 * Get the medium type representation.
	 * @return a <code>String</code> medium type representation, <code>null</code> when not set
	 */
	String getType();
	
	/**
	 * Set the medium type representation.
	 * @param type
	 * @throws IllegalArgumentException when the type is <code>null</code> or empty
	 */
	void setType(final String type) throws IllegalArgumentException;

}
