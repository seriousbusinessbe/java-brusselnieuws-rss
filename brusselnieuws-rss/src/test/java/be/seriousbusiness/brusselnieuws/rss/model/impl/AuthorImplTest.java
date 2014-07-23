package be.seriousbusiness.brusselnieuws.rss.model.impl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import be.seriousbusiness.brusselnieuws.rss.model.Author;

public class AuthorImplTest {
	
	@Test
	public void testBuilder(){
		final String name="Test name";
		final Author author=new AuthorImpl.Builder().name(name).build();
		assertEquals("The name is not equal to the one set",name.toLowerCase(),author.getName());
	}

}
