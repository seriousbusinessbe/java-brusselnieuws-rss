package be.seriousbusiness.brusselnieuws.rss.model.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableCategoryImpl;

public class CategoryImplTest {
	
	@Test
	public void testBuilder() throws MalformedURLException{
		final URL link=new URL("http://www.brusselnieuws.be");
		final String name="Test name";
		final Category category=new AdaptableCategoryImpl.Builder().link(link).name(name).build();
		assertEquals("The link is not equal to the one set",link,category.getLink());
		assertEquals("The name is not equal to the one set",name.toLowerCase(),category.getName());
	}

}
