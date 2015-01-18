package be.seriousbusiness.brusselnieuws.rss.reader.model.factory.impl;

import java.net.URL;

import be.seriousbusiness.brusselnieuws.rss.reader.model.factory.FeedFactory;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;

public class FeedImplFactory implements FeedFactory<FeedImpl> {

	@Override
	public FeedImpl create(final URL url) {
		return new FeedImpl.Builder().link(url).title("#").build();
	}

}
