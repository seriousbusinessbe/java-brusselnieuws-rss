package be.seriousbusiness.brusselnieuws.rss.reader.reader.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.reader.BrusselNieuwsRssReader;

import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndPerson;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class BrusselNieuwsRssReaderImpl implements BrusselNieuwsRssReader<FeedImpl> {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssReaderImpl.class);
	
	@Override
	public void updateFeed(final FeedImpl feed) {
		if(feed!=null && feed.getLink()!=null) {
			final URL link=feed.getLink();
			try {
				final SyndFeed syndFeed=new SyndFeedInput().build(new XmlReader(link));
				feed.setLink(new URL(syndFeed.getLink()));
				feed.setTitle(syndFeed.getTitle());
				feed.setDescription(syndFeed.getDescription());
				// Add articles:
				@SuppressWarnings("unchecked")
				final List<SyndEntry> feedEntries=syndFeed.getEntries();
				if(feedEntries!=null){
					for(final SyndEntry syndEntry : feedEntries){
						// Add article:
						// Add authors:
						final Collection<AuthorImpl> authors=new HashSet<AuthorImpl>();
						@SuppressWarnings("unchecked")
						final List<SyndPerson> entryAuthors=syndEntry.getAuthors();
						if(entryAuthors!=null){
							for(final SyndPerson syndPerson : entryAuthors){
								final AuthorImpl author=new AuthorImpl.Builder().name(syndPerson.getName()).build();
								authors.add(author);
							}
						}
						// Add categories:
						final Collection<CategoryImpl> categories=new HashSet<CategoryImpl>();
						@SuppressWarnings("unchecked")
						final List<SyndCategory> syndCategories=syndEntry.getCategories();
						if(syndCategories!=null){
							for(final SyndCategory syndCategory : syndCategories){
								CategoryImpl category=null;
								try {
									category=new CategoryImpl.Builder().
										link(new URL(syndCategory.getTaxonomyUri())).
										name(syndCategory.getName()).build();
								}catch (final MalformedURLException e) {
									LOGGER.error("The category's link was incorrect",e);
									category=new CategoryImpl.Builder().
											name(syndCategory.getName()).build();
								}
								categories.add(category);
							}
						}
						// Add media:
						final Collection<MediumImpl> media=new HashSet<MediumImpl>();
						@SuppressWarnings("unchecked")
						final List<SyndEnclosure> syndEnclosures=syndEntry.getEnclosures();
						if(syndEnclosures!=null){
							for(final SyndEnclosure syndEnclosure : syndEnclosures){
								MediumImpl medium=null; 
								final MediumTypeImpl mediumType=new MediumTypeImpl.Builder().type(syndEnclosure.getType()).build();
								try {
									medium=new MediumImpl.Builder().
										link(new URL(syndEnclosure.getUrl())).
										size(syndEnclosure.getLength()).
										type(mediumType).build();
								} catch (final MalformedURLException e) {
									LOGGER.error("The medium's link was incorrect",e);
									medium=new MediumImpl.Builder().
											size(syndEnclosure.getLength()).
											type(mediumType).build();
								}
								media.add(medium);
							}
						}
						try {
							final ArticleImpl article=new ArticleImpl.Builder().
								archived(false).
								authors(authors).
								categories(categories).
								description(syndEntry.getDescription().getValue()).
								favorite(false).
								link(new URL(syndEntry.getLink())).
								media(media).
								publicationDate(new DateTime(syndEntry.getPublishedDate().getTime())).
								read(false).
								title(syndEntry.getTitle()).build();
							feed.add(article);
						}catch(final MalformedURLException e){
							LOGGER.error("The article's link was incorrect",e);
						}					
					}
				}
			} catch (final IllegalArgumentException e) {
				LOGGER.error("Feed type '{}' could not be understood by the parsers",link.toString(),e);
			} catch (final FeedException e) {
				LOGGER.error("Feed '{}' could not be parsed",link.toString(),e);
			} catch (final IOException e) {
				LOGGER.error("URL stream '{}' could not be read",link.toString(),e);
			}
		}
	}

}
