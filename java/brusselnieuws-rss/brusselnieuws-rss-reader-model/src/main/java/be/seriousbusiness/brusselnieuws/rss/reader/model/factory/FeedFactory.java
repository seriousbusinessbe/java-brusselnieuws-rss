package be.seriousbusiness.brusselnieuws.rss.reader.model.factory;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;

public interface FeedFactory<FEED extends Feed<?,?,?,?,?>> {
	
	FEED create(final URL url);

}
