package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleArticleMock;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AbstractAdaptableFeedTest;

public class AdaptableFeedImplTest extends AbstractAdaptableFeedTest<AdaptableFeedImpl> {

	@Override
	public void before() {
		adaptable=new AdaptableFeedImpl.Builder().title("Test title").build();
	}
	
	/**
	 * Test if the all values set using the Builder 
	 * @throws MalformedURLException
	 */
	@Test
	public void testBuilder() throws MalformedURLException{
		final String title="Test title";
		final String description="Test description";
		final URL link=new URL("http://www.brusselnieuws.be");
		final Article article=new SimpleArticleMock();
		final Feed feed=new AdaptableFeedImpl.Builder().
				title(title).
				description(description).
				link(link).
				add(article).
				build();
		assertEquals("The title is not set",title,feed.getTitle());
		assertEquals("The description is not set",description,feed.getDescription());
		assertEquals("The link is not set",link,feed.getLink());
		final List<Article> articles=feed.getArticles();
		assertNotNull("The list of articles is null",articles);
		assertEquals("The number of articles should be one",1,articles.size());
		assertEquals("The retrieved article is not equal to the one set",article,articles.get(0));
	}

}
