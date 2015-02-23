package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;

/**
 * Represents an {@link Article}'s creator.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface Creator extends Id<BigInteger>, Cloneable  {
	
	/**
	 * Get the name.
	 * @return the name in lower case
	 */
	String getName();
	
	/**
	 * Set a name
	 * @param name
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	void setName(final String name) throws IllegalArgumentException;

}
