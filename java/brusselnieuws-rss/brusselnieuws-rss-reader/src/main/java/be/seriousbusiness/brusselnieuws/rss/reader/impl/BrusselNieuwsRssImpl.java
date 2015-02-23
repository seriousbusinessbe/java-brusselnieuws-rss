package be.seriousbusiness.brusselnieuws.rss.reader.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.BrusselNieuwsRss;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CreatorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;

/**
 * Manages all Brussel Nieuws RSS {@link FeedImpl}.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class BrusselNieuwsRssImpl extends BrusselNieuwsRss<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,CreatorImpl,ArticleImpl,FeedImpl> {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssImpl.class);
	
	/**
	 * Updates and saves a feed.</br>
	 * To improve performance, a save is only performed when changes are made related to the update.</br>
	 * @param feed non <code>null</code> feed containing a non <code>null</code> link
	 * @return the updated feed
	 */
	@Override
	public FeedImpl update(final FeedImpl feed) {
		if(feed!=null && feed.getLink()!=null) {
			final FeedImpl feedBeforeUpdate=(FeedImpl)feed.clone();
			brusselNieuwsRssReader.updateFeed(feed);
			if(!feedBeforeUpdate.equals(feed)) {
				LOGGER.debug("Updating feed '{}' resulted in changes. Se it needs to be saved.",feed.getTitle());
				return feedManager.save(feed);
			}
		}
		return feed;
	}

}
