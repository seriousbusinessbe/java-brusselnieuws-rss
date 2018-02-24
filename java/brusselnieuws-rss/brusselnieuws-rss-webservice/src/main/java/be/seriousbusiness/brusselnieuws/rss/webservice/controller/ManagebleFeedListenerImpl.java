package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.listener.ManagebleFeedListener;

public class ManagebleFeedListenerImpl implements ManagebleFeedListener {
	private int numberOfNotfications=0;
	private Map<Feed<?, ?, ?, ?, ?, ?>, Collection<Article<?, ?, ?, ?, ?>>> notifications=new HashMap<>();
	private static final Logger LOGGER=LoggerFactory.getLogger(ManagebleFeedListenerImpl.class);

	@Override
	public void notify(final Feed<?, ?, ?, ?, ?, ?> feed,final Article<?, ?, ?, ?, ?> article) {
		numberOfNotfications++;
		/*
		Collection<Article<?, ?, ?, ?, ?>> notifiedArticles=new ArrayList<>();
		final Iterator<Feed<?, ?, ?, ?, ?, ?>> notifiedFeedsIterator=notifications.keySet().iterator();
		while(notifiedFeedsIterator.hasNext()) {
			final Feed<?, ?, ?, ?, ?, ?> notifiedFeed=notifiedFeedsIterator.next();
			if(notifiedFeed!=null && notifiedFeed.getLink().equals(feed.getLink())) {
				notifiedArticles=notifications.get(notifiedFeed);
				notifications.remove(notifiedFeed);
				break; sk 
			}
		}
		if(feed!=null) {
			notifiedArticles.add(article);
			notifications.put(feed,notifiedArticles);
		}
		*/
		Set<Feed<?, ?, ?, ?, ?, ?>> notifiedFeeds=notifications.keySet();
		for(final Feed<?, ?, ?, ?, ?, ?> notifiedFeed : notifiedFeeds) {
			LOGGER.error("# {} - {}",notifiedFeed.getArticles().size(),notifiedFeed.getTitle());
		}
		LOGGER.error("=> {} - {}",feed.getArticles().size(),feed.getTitle());
		
		if(!notifications.containsKey(feed)) {
			notifications.put(feed,new ArrayList<Article<?, ?, ?, ?, ?>>());
		}
		notifications.get(feed).add(article);
	}
	
	@Override
	public void reset() {
		numberOfNotfications=0;
		notifications.clear();
	}
	
	@Override
	public int getNumberOfNotifications() {
		return numberOfNotfications;
	}

	@Override
	public Map<Feed<?, ?, ?, ?, ?, ?>, Collection<Article<?, ?, ?, ?, ?>>> getNotifications() {
		return notifications;
	}

}
