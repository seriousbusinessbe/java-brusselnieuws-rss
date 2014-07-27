package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableMediumImpl;

public class MediumImplTest {
	
	@Test
	public void testBuilder() throws MalformedURLException{
		final URL link=new URL("http://www.brusselnieuws.be");
		final long size=28764;
		final MediumType mediumType=MediumType.IMAGE_PNG;
		final Medium medium=new AdaptableMediumImpl.Builder().
				link(link).
				size(size).
				type(mediumType).
				build();
		assertEquals("The link is not equal to the one set",link,medium.getLink());
		assertEquals("The size is not equal to the one set",size,medium.getSize(),0.0);
		assertEquals("The medium is not equal to the one set",mediumType,medium.getType());
	}

}
