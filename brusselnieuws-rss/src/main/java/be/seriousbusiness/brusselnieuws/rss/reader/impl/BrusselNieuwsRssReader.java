package be.seriousbusiness.brusselnieuws.rss.reader.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableArticle;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableFeed;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.RssReader;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndPerson;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class BrusselNieuwsRssReader implements RssReader {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssReader.class);
	private final URL url;
	private AdaptableFeed adaptableFeed,mainAdaptableFeed;
	private Manager<Author> authorManager;
	private Manager<Category> categoryManager;
	
	/**
	 * Create a new BrusselNieuwsRssReader looking for data on a given URL.
	 * @param url the URL to read feed from
	 * @throws IllegalArgumentException when the URL is <code>null</code>
	 */
	public BrusselNieuwsRssReader(final URL url) throws IllegalArgumentException{
		if(url==null){
			throw new IllegalArgumentException("The url is null");
		}
		this.url=url;
	}
	
	@Override
	public void setAdaptableFeed(final AdaptableFeed adaptableFeed) throws IllegalArgumentException {
		if(adaptableFeed==null){
			throw new IllegalArgumentException("The Adaptable Feed is null");
		}
		this.adaptableFeed=adaptableFeed;
	}
	
	public void setMainAdaptableFeed(final AdaptableFeed mainAdaptableFeed) throws IllegalArgumentException {
		if(mainAdaptableFeed==null){
			throw new IllegalArgumentException("The main adaptable feed is null");
		}
		this.mainAdaptableFeed=mainAdaptableFeed;
	}
	
	/**
	 * Set an AuthorManager which will be used to add authors from all found articles.
	 * @param authorManager
	 * @throws IllegalArgumentException when the author manager is <code>null</code>
	 */
	public void setAuthorManager(final Manager<Author> authorManager) throws IllegalArgumentException{
		if(authorManager==null){
			throw new IllegalArgumentException("The author manager is null");
		}
		this.authorManager=authorManager;
	}
	
	/**
	 * 
	 * @param categoryManager
	 * @throws IllegalArgumentException
	 */
	public void setCategoryManager(final Manager<Category> categoryManager) throws IllegalArgumentException{
		if(categoryManager==null){
			throw new IllegalArgumentException("The category manager is null");
		}
		this.categoryManager=categoryManager;
	}

	@Override
	public void updateFeed() {
		if(adaptableFeed!=null){
			updateFeed(adaptableFeed,mainAdaptableFeed,url,authorManager,categoryManager);
		}
	}
	
	private static final void updateFeed(final AdaptableFeed adaptableFeed,final AdaptableFeed mainAdaptableFeed,final URL url,final Manager<Author> authorManager,final Manager<Category> categoryManager){
		final SyndFeedInput syndFeedInput=new SyndFeedInput();
		try {
			final SyndFeed syndFeed=syndFeedInput.build(new XmlReader(url));
			adaptableFeed.setTitle(syndFeed.getTitle());
			adaptableFeed.setDescription(syndFeed.getDescription());
			adaptableFeed.setLink(new URL(syndFeed.getLink()));
			@SuppressWarnings("unchecked")
			final List<SyndEntry> feedEntries=syndFeed.getEntries();
			if(feedEntries!=null){
				for(final SyndEntry syndEntry : feedEntries){
					if(mainAdaptableFeed!=null){
						adaptableFeed.add(mainAdaptableFeed.add(getArticle(syndEntry,authorManager,categoryManager)));
					}else{
						adaptableFeed.add(getArticle(syndEntry,authorManager,categoryManager));
					}
				}
			}
		} catch (final IllegalArgumentException e) {
			LOGGER.error("Feed type '{}' could not be understood by the parsers",url.toString(),e);
		} catch (final FeedException e) {
			LOGGER.error("Feed '{}' could not be parsed",url.toString(),e);
		} catch (final IOException e) {
			LOGGER.error("URL stream '{}' could not be read",url.toString(),e);
		}
	}
	
	private static final Article getArticle(final SyndEntry syndEntry,final Manager<Author> authorManager,final Manager<Category> categoryManager) {
		try{
			final SyndContent syndContent=syndEntry.getDescription();
			final AdaptableArticle adaptableArticle=new AdaptableArticleImpl.Builder().
				title(syndEntry.getTitle()).
				link(new URL(syndEntry.getLink())).
				description(syndContent.getValue()).
				publicationDate(new DateTime(syndEntry.getPublishedDate().getTime())).build();	
			@SuppressWarnings("unchecked")
			final List<SyndPerson> entryAuthors=syndEntry.getAuthors();
			if(entryAuthors!=null){
				for(final SyndPerson syndPerson : entryAuthors){
					final Author author=BrusselNieuwsRssReaderHelper.map(syndPerson);
					adaptableArticle.add(author);
					if(authorManager!=null){
						authorManager.add(author);
					}
				}
			}
			/*
			 * TODO: inspect this
			final List<SyndPerson> syndContributors=syndEntry.getContributors();
			if(syndContributors!=null){
				for(final SyndPerson syndPerson : syndContributors){
					//LOGGER.debug("{}",syndPerson);
				}
			}
			*/
			@SuppressWarnings("unchecked")
			final List<SyndCategory> syndCategories=syndEntry.getCategories();
			if(syndCategories!=null){
				for(final SyndCategory syndCategory : syndCategories){
					final Category category=BrusselNieuwsRssReaderHelper.map(syndCategory);
					adaptableArticle.add(category);
					if(categoryManager!=null){
						categoryManager.add(category);
					}
				}
			}
			@SuppressWarnings("unchecked")
			final List<SyndEnclosure> syndEnclosures=syndEntry.getEnclosures();
			if(syndEnclosures!=null){
				for(final SyndEnclosure syndEnclosure : syndEnclosures){
					adaptableArticle.add(BrusselNieuwsRssReaderHelper.map(syndEnclosure));
				}
			}
			return adaptableArticle;
		}catch(final MalformedURLException e){
			LOGGER.error("The article's link was incorrect",e);
			return null;
		}
	}

}
