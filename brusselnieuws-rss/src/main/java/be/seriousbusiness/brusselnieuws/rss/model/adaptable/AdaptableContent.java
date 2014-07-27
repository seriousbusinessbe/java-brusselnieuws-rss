package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.model.Content;

/**
 * Represents a basic content entity,</br>
 * capable of being altered 
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface AdaptableContent<ID> extends Content<ID> {
	
	/**
	 * Set a new title.</br>
	 * Empty spaces will be trimmed off.
	 * @param title
	 * @throws IllegalArgumentException when <code>null</code> or empty
	 */
	void setTitle(final String title) throws IllegalArgumentException;
	
	/**
	 * Set a new link
	 * @param link
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	 void setLink(final URL link) throws IllegalArgumentException;
		
	/**
	 * Set a new description.</br>
	 * Empty spaces will be trimmed off.
	 * @param description
	 * @throws IllegalArgumentException when <code>null</code>
	 */
	 void setDescription(final String description) throws IllegalArgumentException;
}
