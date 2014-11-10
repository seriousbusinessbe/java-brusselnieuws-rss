package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import java.math.BigInteger;

/**
 * Represents a DTO (data transfer object) responsible for category information transfer</br>
 * between a datastore and model.
 * @author stefanborghys
 *
 */
public interface CategoryDTO extends IdDTO<BigInteger> {
	
	/**
	 * Get the category name.
	 * @return the category name, <code>null</code> when not set
	 */
	String getName();
	
	/**
	 * Set a category name.
	 * @param name
	 */
	void setName(final String name);
	
	/**
	 * Get the URL location of this category's web page
	 * @return <code>String</code> URL location, <code>null</code> when not set
	 */
	String getLink();
	
	/**
	 * Set the URL location of this category's web page
	 * @param link <code>String</code> URL location
	 */
	void setLink(final String link);

}
