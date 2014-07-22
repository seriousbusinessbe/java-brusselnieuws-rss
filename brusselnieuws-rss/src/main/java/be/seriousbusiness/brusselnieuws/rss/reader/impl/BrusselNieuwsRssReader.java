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
import be.seriousbusiness.brusselnieuws.rss.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
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
	private final AdaptableFeed adaptableFeed;
	private final Manager<Author> authorManager;
	private final Manager<Category> categoryManager;
	
	/**
	 * Create a new BrusselNieuwsRssReader looking for data on a given URL.
	 * @param url
	 * @param feed
	 * @param authorManager
	 * @param categoryManager
	 * @throws IllegalArgumentException when the URL, feed, author manager or category manager is <code>null</code>
	 */
	public BrusselNieuwsRssReader(final URL url,final AdaptableFeed adaptableFeed,
			final Manager<Author> authorManager,
			final Manager<Category> categoryManager) throws IllegalArgumentException{
		if(url==null){
			throw new IllegalArgumentException("The url is null");
		}
		if(adaptableFeed==null){
			throw new IllegalArgumentException("The feed is null");
		}
		if(authorManager==null){
			throw new IllegalArgumentException("The author manager is null");
		}
		if(categoryManager==null){
			throw new IllegalArgumentException("The category manager is null");
		}
		this.url=url;
		this.adaptableFeed=adaptableFeed;
		this.authorManager=authorManager;
		this.categoryManager=categoryManager;
	}

	@Override
	public Feed getFeed() {
		updateFeed(adaptableFeed,url,authorManager,categoryManager);
		return adaptableFeed;
	}
	
	private static final void updateFeed(final AdaptableFeed adaptableFeed,final URL url,final Manager<Author> authorManager,final Manager<Category> categoryManager){
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
					adaptableFeed.add(getArticle(syndEntry,authorManager,categoryManager));
				}
			}
		} catch (final IllegalArgumentException e) {
			LOGGER.error("The feed type could not be understood by the parsers",e);
		} catch (final FeedException e) {
			LOGGER.error("The feed could not be parsed",e);
		} catch (final IOException e) {
			LOGGER.error("The URL stream could not be read",e);
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
					authorManager.add(author);
					adaptableArticle.add(author);
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
					categoryManager.add(category);
					adaptableArticle.add(category);
				}
			}
			@SuppressWarnings("unchecked")
			final List<SyndEnclosure> syndEnclosures=syndEntry.getEnclosures();
			if(syndEnclosures!=null){
				for(final SyndEnclosure syndEnclosure : syndEnclosures){
					final Medium medium=BrusselNieuwsRssReaderHelper.map(syndEnclosure);
					adaptableArticle.add(medium);
				}
			}
			return adaptableArticle;
		}catch(final MalformedURLException e){
			LOGGER.error("The article's link was incorrect",e);
			return null;
		}
	}
	
	

}
