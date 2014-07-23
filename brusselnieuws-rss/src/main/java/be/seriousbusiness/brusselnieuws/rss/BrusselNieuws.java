package be.seriousbusiness.brusselnieuws.rss;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Municipality;

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
	
	Feed getNews();
	Feed getNewsSurvey();
	Feed getSocietyNews();
	Feed getCityNews();
	Feed getPoliticalNews();
	Feed getHumanNews();
	Feed getEconomicalNews();
	Feed getSportNews();
	
	Feed getNews(final Municipality municipality);

}
