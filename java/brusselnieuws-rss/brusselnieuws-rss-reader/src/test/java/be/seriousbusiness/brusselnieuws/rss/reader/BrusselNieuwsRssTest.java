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

/**
 * {@link BrusselNieuwsRss} test case implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:config/test-brusselnieuws-rss-reader-config.xml")
public class BrusselNieuwsRssTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssTest.class);
	@Autowired
	private BrusselNieuwsRss<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,ArticleImpl,FeedImpl> brusselNieuwsRss;
	
	/**
	 * Tests if the {@link BrusselNieuwsRss} implementation under test is set.
	 */
	@Test
	public void testBrusselNieuwsRss() {
		Assert.assertNotNull("The brusselNieuwsRss cannot be null",brusselNieuwsRss);
	}
	
	private static final void testGetFeed(final FeedImpl feed) {
		Assert.assertNotNull("The retrieved feed should not be null",feed);
		LOGGER.debug("{}",feed);
	}
	
	/* NEWS */
	
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
	
	/* CULTURE */
	
	@Test
	public void testGetCultureSurvey() {
		testGetFeed(brusselNieuwsRss.getCultureSurvey());
	}
	
	@Test
	public void testGetGeneralCultureNews() {
		testGetFeed(brusselNieuwsRss.getGeneralCultureNews());
	}
	
	@Test
	public void testGetExpoNews() {
		testGetFeed(brusselNieuwsRss.getExpoNews());
	}
	
	@Test
	public void testGetMusicalNews() {
		testGetFeed(brusselNieuwsRss.getMusicalNews());
	}
	
	@Test
	public void testGetFilmNews() {
		testGetFeed(brusselNieuwsRss.getFilmNews());
	}
		
	@Test
	public void testGetStageNews() {
		testGetFeed(brusselNieuwsRss.getStageNews());
	}
	
	@Test
	public void testGetEventNews() {
		testGetFeed(brusselNieuwsRss.getEventNews());
	}
	
	@Test
	public void testGetShoppingNews() {
		testGetFeed(brusselNieuwsRss.getShoppingNews());
	}
	
	/* FOOD & DRINKS */
	
	@Test
	public void testGetFoodAndDrinksSurvey() {
		testGetFeed(brusselNieuwsRss.getFoodAndDrinksSurvey());
	}
	
	@Test
	public void testGetGeneralFoodAndDrinksNews() {
		testGetFeed(brusselNieuwsRss.getGeneralFoodAndDrinksNews());
	}
	
	@Test
	public void testGetCulinaryNews() {
		testGetFeed(brusselNieuwsRss.getCulinaryNews());
	}
	
	@Test
	public void testGetBarNews() {
		testGetFeed(brusselNieuwsRss.getBarNews());
	}
	
	@Test
	public void testGetRestaurantNews() {
		testGetFeed(brusselNieuwsRss.getRestaurantNews());
	}
	
	/* OPINION */
	
	@Test
	public void testGetOpinionSurvey() {
		testGetFeed(brusselNieuwsRss.getOpinionSurvey());
	}
	
	/* MUNICIPALITIES */
	
	@Test
	public void testGetAnderlechtNews() {
		testGetFeed(brusselNieuwsRss.getAnderlechtNews());
	}
	
	@Test
	public void testGetBrusselNews() {
		testGetFeed(brusselNieuwsRss.getBrusselNews());
	}
	
	@Test
	public void testGetElseneNews() {
		testGetFeed(brusselNieuwsRss.getElseneNews());
	}
	
	@Test
	public void testGetEvereNews() {
		testGetFeed(brusselNieuwsRss.getEvereNews());
	}
	
	@Test
	public void testGetGanshorenNews() {
		testGetFeed(brusselNieuwsRss.getGanshorenNews());
	}
	
	@Test
	public void testGetHarenNews() {
		testGetFeed(brusselNieuwsRss.getHarenNews());
	}
	
	@Test
	public void testGetJetteNews() {
		testGetFeed(brusselNieuwsRss.getJetteNews());
	}
	
	@Test
	public void testGetKoekelbergNews() {
		testGetFeed(brusselNieuwsRss.getKoekelbergNews());
	}
	
	@Test
	public void testGetLakenNews() {
		testGetFeed(brusselNieuwsRss.getLakenNews());
	}
	
	@Test
	public void testGetNederOverHeembeekNews() {
		testGetFeed(brusselNieuwsRss.getNederOverHeembeekNews());
	}
	
	@Test
	public void testGetOudergemNews() {
		testGetFeed(brusselNieuwsRss.getOudergemNews());
	}
	
	@Test
	public void testGetSchaarbeekNews() {
		testGetFeed(brusselNieuwsRss.getSchaarbeekNews());
	}
	
	@Test
	public void testGetSintAgathaBerchemNews() {
		testGetFeed(brusselNieuwsRss.getSintAgathaBerchemNews());
	}
	
	@Test
	public void testGetSintGillisNews() {
		testGetFeed(brusselNieuwsRss.getSintGillisNews());
	}
	
	@Test
	public void testGetSintJansMolenbeekNews() {
		testGetFeed(brusselNieuwsRss.getSintJansMolenbeekNews());
	}
	
	@Test
	public void testGetSintJoostTenNodeNews() {
		testGetFeed(brusselNieuwsRss.getSintJoostTenNodeNews());
	}
	
	@Test
	public void testGetSintLambrechtsWoluweNews() {
		testGetFeed(brusselNieuwsRss.getSintLambrechtsWoluweNews());
	}
	
	@Test
	public void testGetSintPietersWoluweNews() {
		testGetFeed(brusselNieuwsRss.getSintPietersWoluweNews());
	}
	
	@Test
	public void testGetUkkelNews() {
		testGetFeed(brusselNieuwsRss.getUkkelNews());
	}
	
	@Test
	public void testGetVorstNews() {
		testGetFeed(brusselNieuwsRss.getVorstNews());
	}
	
	@Test
	public void testGetWatermaalBosvoordeNews() {
		testGetFeed(brusselNieuwsRss.getWatermaalBosvoordeNews());
	}
	 
	@Ignore
	@Test
	public void testGetNewsHeadLinesUpdate() throws InterruptedException {
		Assert.assertNotNull("The brusselNieuwsRss cannot be null",brusselNieuwsRss);
		final FeedImpl feed=brusselNieuwsRss.getNewsHeadLines();
		feed.attach(new FeedListener() {
			
			@Override
			public void notify(Feed<?, ?, ?, ?, ?> feed, Article<?, ?, ?, ?> article) {
				LOGGER.error("BREAKING! - {}",article.getTitle());
				LOGGER.error("Feed: {}",feed);
				LOGGER.error("Article: {}",article);
			}
		});
		LOGGER.debug("News headlines: \n{}",feed);
		while(true) {
			LOGGER.info("Check for news headline updates...");
			brusselNieuwsRss.update(feed);
			Thread.sleep(300000); // every 5 mins
		}
	}
}
