package be.seriousbusiness.brusselnieuws.rss;

import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
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
public class BrusselNieuws {
	private Map<Municipality,RssReader> municipalitiesReaders;
	private Manager<Author> authorManager;
	private Manager<Category> categoryManager;
	
	public void setMunicipalitiesReaders(final Map<Municipality,RssReader> municipalitiesReaders){
		this.municipalitiesReaders=municipalitiesReaders;
	}
	
	public void setAuthorManager(final Manager<Author> authorManager){
		this.authorManager=authorManager;
	}
	
	public void setCategoryManager(final Manager<Category> categoryManager){
		this.categoryManager=categoryManager;
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
