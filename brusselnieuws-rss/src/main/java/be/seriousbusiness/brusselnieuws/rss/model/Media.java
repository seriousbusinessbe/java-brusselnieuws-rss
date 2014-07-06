package be.seriousbusiness.brusselnieuws.rss.model;

import java.net.URL;

/**
 * Represents media attached to an article published on a brusselnieuws.be feed.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Media {
	
	/**
	 * Get the size in bytes.
	 * @return number of bytes.
	 */
	long getSize();
	
	/**
	 * Get the web URL.
	 * @return the web URL
	 */
	URL getLink();
	
	/**
	 * Get the type of content.
	 * @return the content type
	 */
	MediaType getType();
}
