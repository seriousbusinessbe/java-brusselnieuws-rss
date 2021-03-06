package be.seriousbusiness.brusselnieuws.rss.reader.reader.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.BrusselNieuwsRssReader;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CreatorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.util.StringUtil;

import com.sun.syndication.feed.module.DCModuleImpl;
import com.sun.syndication.feed.synd.SyndCategory;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndPerson;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * {@link BrusselNieuwsRssReader} {@link FeedImpl} implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class BrusselNieuwsRssReaderImpl implements BrusselNieuwsRssReader<FeedImpl> {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssReaderImpl.class);
	private static final SyndFeedInput SYNDFEEDINPUT=new SyndFeedInput();
	private static final String CROPPED_IMAGE_URL_PART="bn_220_crop";
	private static final String NORMAL_IMAGE_URL_PART="bn_460";
	
	@Override
	public void updateFeed(final FeedImpl feed) {
		if(feed!=null && feed.getLink()!=null) {
			final URL link=feed.getLink();
			try {
				final SyndFeed syndFeed=SYNDFEEDINPUT.build(new XmlReader(link));
				feed.setLink(new URL(syndFeed.getLink()));
				feed.setTitle(syndFeed.getTitle());
				feed.setDescription(StringUtil.removeHTMLTags(syndFeed.getDescription()));
				// Add articles:
				@SuppressWarnings("unchecked")
				final List<SyndEntry> feedEntries=syndFeed.getEntries();
				if(feedEntries!=null){
					for(final SyndEntry syndEntry : feedEntries){	
						// Add article:
						// Add creators:
						final Collection<CreatorImpl> creators=new HashSet<CreatorImpl>();
						for(final Object obj : syndEntry.getModules()) {
							if(obj instanceof DCModuleImpl) {
								final DCModuleImpl dcModuleImpl=(DCModuleImpl)obj;
								final String creator=dcModuleImpl.getCreator();
								if(creator!=null) {
									final String[] brusselNieuwsCreators=((creator).split("[\u00A9,/,@]"));
									for(final String brusselNieuwsCreator : brusselNieuwsCreators) {
										if(brusselNieuwsCreator!=null && !brusselNieuwsCreator.isEmpty()) {
											creators.add(new CreatorImpl.Builder().name(brusselNieuwsCreator.trim()).build());
										}
									}
								}
							}
						}
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
								try { // Add cropped thumbnail:
									medium=new MediumImpl.Builder().
										link(new URL(syndEnclosure.getUrl())).
										size(syndEnclosure.getLength()).
										type(mediumType).build();
									media.add(medium);
								} catch (final MalformedURLException e) {
									LOGGER.debug("The medium's link was incorrect",e);
								}
								if(syndEnclosure.getUrl().contains(CROPPED_IMAGE_URL_PART)) {
									try { // Add (guessed) original image:
										medium=new MediumImpl.Builder().
												link(new URL(syndEnclosure.getUrl().replace(CROPPED_IMAGE_URL_PART,NORMAL_IMAGE_URL_PART))).
												size(syndEnclosure.getLength()*2).
												type(mediumType).build();
										media.add(medium);
									} catch (final MalformedURLException e) {
										LOGGER.debug("The medium's link was incorrect",e);
									}
								}
							}
						}
						try {
							final ArticleImpl article=new ArticleImpl.Builder().
								archived(false).
								authors(authors).
								categories(categories).
								creators(creators).
								description(StringUtil.removeHTMLTags(syndEntry.getDescription().getValue())).
								favorite(false).
								link(new URL(syndEntry.getLink())).
								media(media).
								publicationDate(new DateTime(syndEntry.getPublishedDate().getTime())).
								read(false).
								title(syndEntry.getTitle()).build();
							feed.add(article);
						} catch(final MalformedURLException e){
							LOGGER.error("The article's link is incorrect",e);
						} catch(final IllegalArgumentException e) {
							LOGGER.error("Article '{}' from feed '{}' could not be created",syndEntry.getTitle(),link.toString(),e);
						}
					}
				}
			} catch (final IllegalArgumentException e) {
				LOGGER.error("Feed '{}' could not be understood by the parsers",link.toString(),e);
			} catch (final FeedException e) {
				LOGGER.error("Feed '{}' could not be parsed",link.toString(),e);
			} catch (final SocketException e) {
				LOGGER.error("Feed '{}' could not be read, possible due to connection problems",link.toString(),e);
			} catch(final UnknownHostException e) {
				LOGGER.error("Feed '{}' could not be found, possible due to connection problems",link.toString(),e);
			} catch (final IOException e) {
				final StringBuilder error=new StringBuilder("URL stream '{}' could not be read");
				if(e.getMessage().startsWith("Server returned HTTP response code:")) {
					if(e.getMessage().contains("503")) {
						error.append(", server returned STATUS CODE 503 - \"Service is unavailable\"");
					}
				}
				LOGGER.error(error.toString(),link.toString(),e);
			}
		}
	}

}
