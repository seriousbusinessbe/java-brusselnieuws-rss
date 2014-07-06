package be.seriousbusiness.brusselnieuws.rss.model;

import java.net.URL;

/**
 * Represents a basic content entity.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Content {
	
	/**
	 * Get the title.
	 * @return the title
	 */
	String getTitle();
	
	/**
	 * Get the web URL.
	 * @return the web URL
	 */
	URL getLink();
		
	/**
	 * Get the description.
	 * @return the description
	 */
	String getDescription();
	
	/**
	 * Check if a description is set.
	 * @return <code>true</code> when the description is not <code>null</code> or empty
	 */
	boolean hasDescription();
}
