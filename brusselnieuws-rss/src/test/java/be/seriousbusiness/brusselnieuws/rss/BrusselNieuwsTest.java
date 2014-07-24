package be.seriousbusiness.brusselnieuws.rss;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Manager;
import be.seriousbusiness.brusselnieuws.rss.model.Municipality;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AdaptableFeed;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl.AdaptableFeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.AbstractRssReaderTest;

@ContextConfiguration("classpath:test-application-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BrusselNieuwsTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsTest.class);
	@Autowired
	private BrusselNieuws brusselNieuws;
	private AdaptableFeed adaptableFeed;
	
	@Before
	public void before(){
		adaptableFeed=new AdaptableFeedImpl.Builder().title("Test").build();
	}
	
	@Test
	public void testUpdateFeedLive(){
		for(Municipality municipality : Municipality.values()){
			adaptableFeed=new AdaptableFeedImpl.Builder().title("Test").build();
			brusselNieuws.updateFeed(municipality, adaptableFeed);
			AbstractRssReaderTest.assertAdaptableFeed(adaptableFeed);
		}
		LOGGER.debug("Main FEED: {}",brusselNieuws.getMainFeed());
	}
	
	@Test
	public void testGetCategoryManager(){
		final Manager<Category> categoryManager=brusselNieuws.getCategoryManager();
		assertNotNull("The category manager should not be null",categoryManager);
		assertTrue("The number of categories should be greater than zero",categoryManager.size()>0);
		LOGGER.debug("Live feed categories under test:\n{}",categoryManager);
	}
	
	@Test
	public void testGetAuthorManager(){
		final Manager<Author> authorManager=brusselNieuws.getAuthorManager();
		assertNotNull("The author manager should not be null",authorManager);
		assertEquals("The number of authors should be zero",0,authorManager.size());
	}
}
