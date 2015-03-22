package be.seriousbusiness.brusselnieuws.rss.webservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.listener.ManagebleFeedListener;

public class ManagebleFeedListenerImpl implements ManagebleFeedListener {
	private int numberOfNotfications=0;
	private Map<Feed<?, ?, ?, ?, ?, ?>, Collection<Article<?, ?, ?, ?, ?>>> notifications=new HashMap<>();

	@Override
	public void notify(final Feed<?, ?, ?, ?, ?, ?> feed,final Article<?, ?, ?, ?, ?> article) {
		numberOfNotfications++;
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
