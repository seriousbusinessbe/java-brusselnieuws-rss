package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;

public interface AdaptableMedium extends Medium {
	
	/**
	 * Set a new size.
	 * @param size
	 * @throws IllegalArgumentException when the size is negative
	 */
	void setSize(final long size) throws IllegalArgumentException;
	
	/**
	 * Get the web URL.
	 * @return the web URL
	 */
	
	/**
	 * Set a new link.
	 * @param link
	 * @throws IllegalArgumentException when the link is <code>null</code>
	 */
	void setLink(final URL link) throws IllegalArgumentException;
	
	/**
	 * Set a new Medium Type.
	 * @param mediumType
	 * @throws IllegalArgumentException when the medium type is <code>null</code>
	 */
	void setType(final MediumType mediumType) throws IllegalArgumentException;

}
