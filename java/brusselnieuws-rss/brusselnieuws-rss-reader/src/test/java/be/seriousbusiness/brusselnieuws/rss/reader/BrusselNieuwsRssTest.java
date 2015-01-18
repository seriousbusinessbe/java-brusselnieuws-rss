package be.seriousbusiness.brusselnieuws.rss.reader;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Feed;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumTypeImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.listener.FeedListener;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-application-config.xml")
public class BrusselNieuwsRssTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssTest.class);
	@Autowired
	private BrusselNieuwsRss<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,ArticleImpl,FeedImpl> brusselNieuwsRss;
	
	@Test
	public void testBrusselNieuwsRss() {
		Assert.assertNotNull("The brusselNieuwsRss cannot be null",brusselNieuwsRss);
	}
	
	private static final void testGetFeed(final FeedImpl feed) {
		Assert.assertNotNull("The retrieved feed should not be null",feed);
		LOGGER.debug("{}",feed);
	}
	
	@Test
	public void testGetAwelMerciNews() {
		testGetFeed(brusselNieuwsRss.getAwelMerciNews());
	}
	
	@Test
	public void testGetChildrensNews() {
		testGetFeed(brusselNieuwsRss.getChildrensNews());
	}
	
	@Test
	public void testGetCityNews() {
		testGetFeed(brusselNieuwsRss.getCityNews());
	}
	
	@Test
	public void testGetEconomicalNews() {
		testGetFeed(brusselNieuwsRss.getEconomicalNews());
	}
	
	@Test
	public void testGetNewsHeadLines() {
		testGetFeed(brusselNieuwsRss.getNewsHeadLines());
	}
	
	@Test
	public void testGetNewsSurvey() {
		testGetFeed(brusselNieuwsRss.getNewsSurvey());
	}
	
	@Test
	public void testGetPeopleNews() {
		testGetFeed(brusselNieuwsRss.getPeopleNews());
	}
	
	@Test
	public void testGetPoliticalNews() {
		testGetFeed(brusselNieuwsRss.getPoliticalNews());
	}
	
	@Test
	public void testGetSocietyNews() {
		testGetFeed(brusselNieuwsRss.getSocietyNews());
	}
	
	@Test
	public void testGetSportsNews() {
		testGetFeed(brusselNieuwsRss.getSportsNews());
	}
	 
	@Ignore
	@Test
	public void testGetNewsHeadLinesUpdate() throws InterruptedException {
		Assert.assertNotNull("The brusselNieuwsRss cannot be null",brusselNieuwsRss);
		final FeedImpl feed=brusselNieuwsRss.getNewsHeadLines();
		feed.attach(new FeedListener() {
			
			@Override
			public void notify(Feed<?, ?, ?, ?, ?> feed, Article<?, ?, ?, ?> article) {
				LOGGER.info("BREAKING! - {}",article.getTitle());
			}
		});
		LOGGER.debug("News headlines: \n{}",feed);
		while(true) {
			LOGGER.info("Check for news headline updates...");
			brusselNieuwsRss.update(feed);
			Thread.sleep(60000);
		}
	}
}
