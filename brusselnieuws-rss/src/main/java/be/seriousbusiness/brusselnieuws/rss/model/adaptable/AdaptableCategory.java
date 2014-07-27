package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Category;

/**
 * Represents a category,</br>
 * capable of being altered
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface AdaptableCategory extends Category {
	
	/**
	 * Set a new name.</br>
	 * The name will be converted to lower case and empty spaces will be trimmed off. 
	 * @param name
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	void setName(final String name) throws IllegalArgumentException;
	
	/**
	 * Set a new link.</br>
	 * Empty spaces will be trimmed off.
	 * @param link
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	void setLink(final URL link) throws IllegalArgumentException;

}
