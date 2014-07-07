package be.seriousbusiness.brusselnieuws.rss;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;

/**
 * Makes brusselnieuws.be rss content available 
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
public interface BrusselNieuws {
	
	/**
	 * Get a feed manager.
	 * @return
	 */
	Manager<Feed> getFeedManager();
	
	/**
	 * Get a category manager.
	 * @return
	 */
	Manager<Category> getCategoryManager();
	
	/**
	 * Get an author manager.
	 * @return
	 */
	Manager<Author> getAuthorManager();

}
