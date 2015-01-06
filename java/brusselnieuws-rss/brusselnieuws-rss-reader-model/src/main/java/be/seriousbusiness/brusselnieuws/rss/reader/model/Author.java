package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;

/**
 * Represents an {@link Article} author.
 * @author Stefan Borghys
 * @author Serious Business
 */
public interface Author extends Id<BigInteger> {
	
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
