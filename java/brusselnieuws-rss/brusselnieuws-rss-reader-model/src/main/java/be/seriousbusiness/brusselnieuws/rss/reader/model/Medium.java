package be.seriousbusiness.brusselnieuws.rss.reader.model;

import java.net.URL;

/**
 * Represents a medium attached to an article.
 * @author Stefan Borghys
 * @author Serious Business
 * @param <MEDIUMTYPE> the type of {@link MediumType} implementation
 */
public interface Medium<MEDIUMTYPE extends MediumType> {
	
	/**
	 * Get the size in bytes.
	 * @return number of bytes.
	 */
	long getSize();
	
	/**
	 * Set the size in bytes.
	 * @param size
	 * @throws IllegalArgumentException when the size is negative
	 */
	void setSize(final long size) throws IllegalArgumentException;
	
	/**
	 * Get the web {@link URL}.
	 * @return the web {@link URL}
	 */
	URL getLink();
	
	/**
	 * Set the web {@link URL}.
	 * @param link
	 * @throws IllegalArgumentException when the {@link URL} is <code>null</code>.
	 */
	void setLink(final URL link) throws IllegalArgumentException;
	
	/**
	 * Get the {@link MEDIUMTYPE} of this content.
	 * @return the content {@link MEDIUMTYPE}
	 */
	MEDIUMTYPE getType();
	
	/**
	 * Set the {@link MEDIUMTYPE} of this content.
	 * @param mediumType
	 * @throws IllegalArgumentException when the {@link MEDIUMTYPE} is <code>null</code>.
	 */
	void setType(final MEDIUMTYPE mediumType) throws IllegalArgumentException;
}
