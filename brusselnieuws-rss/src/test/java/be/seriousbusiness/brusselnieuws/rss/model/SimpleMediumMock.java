package be.seriousbusiness.brusselnieuws.rss.model;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMediumMock implements Medium {
	private static final Logger LOGGER=LoggerFactory.getLogger(SimpleMediumMock.class);

	@Override
	public long getSize() {
		return 4000;
	}

	@Override
	public URL getLink() {
		try {
			return new URL("http://www.standaard.be");
		} catch (final MalformedURLException e) {
			LOGGER.error("Malformed URL",e);
			return null;
		}
	}

	@Override
	public MediumType getType() {
		return MediumType.IMAGE_PNG;
	}

	@Override
	public Long getId() {
		return 20191817l;
	}

}
