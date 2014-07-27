package be.seriousbusiness.brusselnieuws.rss.model;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCategoryMock implements Category {
	private static final Logger LOGGER=LoggerFactory.getLogger(SimpleCategoryMock.class);

	@Override
	public String getName() {
		return "Simple Category Mock";
	}

	@Override
	public URL getLink() {
		try {
			return new URL("http://www.bing.be");
		} catch (final MalformedURLException e) {
			LOGGER.error("Malformed URL",e);
			return null;
		}
	}

	@Override
	public Long getId() {
		return 16151413l;
	}

}
