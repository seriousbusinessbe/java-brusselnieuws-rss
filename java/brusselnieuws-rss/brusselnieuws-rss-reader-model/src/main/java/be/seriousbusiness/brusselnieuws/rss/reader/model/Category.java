package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.math.BigInteger;
import java.net.URL;

/**
 * Represents an {@link Article}'s category.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface Category extends Id<BigInteger> {
	
	/**
	 * Get the name.
	 * @return the name in lower case
	 */
	String getName();
	
	/**
	 * Set a name.
	 * @param name
	 * @throws IllegalArgumentException when the name is <code>null</code> or empty
	 */
	void setName(final String name) throws IllegalArgumentException;
	
	/**
	 * Get the web {@link URL}.
	 * @return the web {@link URL}
	 */
	URL getLink();
	
	/**
	 * Set a {@link URL} link
	 * @param link
	 * @throws IllegalArgumentException when the link is <code>null</code>
	 */
	void setLink(final URL link) throws IllegalArgumentException;
		
}
