package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.net.URL;

/**
 * Represents a medium attached to an {@link Article}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <MEDIUMTYPE> the type of {@link MediumType} implementation
 */
public interface Medium<MEDIUMTYPE extends MediumType> {
	
	/**
	 * Gets this medium's size in bytes.
	 * @return number of bytes.
	 */
	long getSize();
	
	/**
	 * Sets this medium's size in bytes.
	 * @param size the medium's size expressed in bytes
	 * @throws IllegalArgumentException when the size is negative
	 */
	void setSize(final long size) throws IllegalArgumentException;
	
	/**
	 * Gets the {@link URL} link location.
	 * @return the web {@link URL}
	 */
	URL getLink();
	
	/**
	 * Sets the {@link URL} link location.
	 * @param link the {@link URL} link location
	 * @throws IllegalArgumentException when the {@link URL} is <code>null</code>.
	 */
	void setLink(final URL link) throws IllegalArgumentException;
	
	/**
	 * Gets this medium's {@link MEDIUMTYPE}.
	 * @return the content {@link MEDIUMTYPE}
	 */
	MEDIUMTYPE getType();
	
	/**
	 * Sets this medium's {@link MEDIUMTYPE}.
	 * @param mediumType the medium's type
	 * @throws IllegalArgumentException when the {@link MEDIUMTYPE} is <code>null</code>.
	 */
	void setType(final MEDIUMTYPE mediumType) throws IllegalArgumentException;
}
