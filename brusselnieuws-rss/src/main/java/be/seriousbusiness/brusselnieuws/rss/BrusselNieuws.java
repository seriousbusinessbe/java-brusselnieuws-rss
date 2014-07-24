package be.seriousbusiness.brusselnieuws.rss;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Municipality;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableFeed;
import be.seriousbusiness.brusselnieuws.rss.reader.RssReader;

/**
 * Makes brusselnieuws.be rss content available 
 * @author Stefan Borghys
 * @author Serious Business
 *
 */
@Component
public class BrusselNieuws {
	private Map<Municipality,RssReader> municipalitiesReaders;
	@Autowired(required=true)
	@Qualifier("authorManager")
	private Manager<Author> authorManager;
	@Autowired(required=true)
	@Qualifier("categoryManager")
	private Manager<Category> categoryManager;
	@Autowired(required=true)
	@Qualifier("mainAdaptableFeed")
	private AdaptableFeed adaptableFeed;
	
	public void setMunicipalitiesReaders(final Map<Municipality,RssReader> municipalitiesReaders){
		this.municipalitiesReaders=municipalitiesReaders;
	}
	
	/**
	 * Get a category manager.
	 * @return
	 */
	Manager<Category> getCategoryManager(){
		return categoryManager;
	}
	
	/**
	 * Get an author manager.
	 * @return
	 */
	Manager<Author> getAuthorManager(){
		return authorManager;
	}
	
	Feed getMainFeed(){
		return adaptableFeed;
	}
	
	
	
	public void updateFeed(final Municipality municipality,final AdaptableFeed adaptableFeed){
		final RssReader rssReader=municipalitiesReaders.get(municipality);
		rssReader.setAdaptableFeed(adaptableFeed);
		rssReader.updateFeed();
	}
	
	/*
	Feed getNews();
	Feed getNewsSurvey();
	Feed getSocietyNews();
	Feed getCityNews();
	Feed getPoliticalNews();
	Feed getHumanNews();
	Feed getEconomicalNews();
	Feed getSportNews();
	*/

}
