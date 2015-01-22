package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;

/**
 * Represents a DTO (data transfer object) responsible for category information transfer between a datastore and model.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public interface CategoryDTO extends IdDTO<BigInteger> {
	
	/**
	 * Gets the name.
	 * @return the category name or <code>null</code> when not set
	 */
	String getName();
	
	/**
	 * Sets the name.
	 * @param name
	 */
	void setName(final String name);
	
	/**
	 * Gets the URL location of this category's web page
	 * @return <code>String</code> URL location, <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Sets the URL location of this category's web page
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);

}
