package be.seriousbusiness.brusselnieuws.rss.model;

/**
 * Represents an article's author published on a brusselnieuws.be feed.
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface Author {
	
	/**
	 * Get the name.
	 * @return the name in lower case
	 */
	String getName();

}
