package be.seriousbusiness.brusselnieuws.rss.model;

import java.net.URL;

/**
 * Represents an article's category published on a brusselnieuws.be feed.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Category {
	
	/**
	 * Get the name.
	 * @return the name
	 */
	String getName();
	
	/**
	 * Get the web URL.
	 * @return the web URL
	 */
	URL getLink();
}
