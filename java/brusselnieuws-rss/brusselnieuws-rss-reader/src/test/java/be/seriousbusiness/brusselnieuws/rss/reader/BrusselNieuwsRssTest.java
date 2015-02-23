package be.seriousbusiness.brusselnieuws.rss.reader;

import java.util.Collection;

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
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CreatorImpl;
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
	private BrusselNieuwsRss<MediumTypeImpl,MediumImpl,CategoryImpl,AuthorImpl,CreatorImpl,ArticleImpl,FeedImpl> brusselNieuwsRss;
	
	/**
	 * Tests if the {@link BrusselNieuwsRss} implementation under test is set.
	 */
	@Test
	public void testBrusselNieuwsRss() {
		Assert.assertNotNull("The brusselNieuwsRss cannot be null",brusselNieuwsRss);
	}
	
	private static final void testGetFeed(final FeedImpl feed) {
		Assert.assertNotNull("The retrieved feed should not be null",feed);
		Assert.assertNotNull("A feed id should not be null",feed.getId());
		Assert.assertNotNull("A feed title should not be null",feed.getTitle());
		Assert.assertFalse("A feed title should not be empty",feed.getTitle().isEmpty());
		// Articles:
		final Collection<ArticleImpl> articleImpls=feed.getArticles();
		Assert.assertNotNull("The collection of retrieved articles should not be null",articleImpls);
		Assert.assertFalse("The collection of retrieved articles should not be empty",articleImpls.isEmpty());
		for(final ArticleImpl article : articleImpls) {
			Assert.assertNotNull("An article should not be null",article);
			Assert.assertNotNull("An article's id should not be null",article.getId());
			Assert.assertNotNull("An article's title should not be null",article.getTitle());
			Assert.assertFalse("An article's title should not be empty",article.getTitle().isEmpty());
			Assert.assertNotNull("An article's description should not be null",article.getDescription());
			Assert.assertFalse("An article's description should not be empty",article.getDescription().isEmpty());
			Assert.assertNotNull("An article's publication date should not be null",article.getPublicationDate());
			// Authors:
			final Collection<AuthorImpl> authorImpls=article.getAuthors();
			Assert.assertNotNull("The collection of article authors should not be null",authorImpls);
			for(final AuthorImpl author : authorImpls) {
				Assert.assertNotNull("An article's author should not be null",author);
				Assert.assertNotNull("An article's author id should not be null",author.getId());
				Assert.assertNotNull("An article's author name should not be null",author.getName());
				Assert.assertFalse("An article's author name should not be empty",author.getName().isEmpty());
			}
			// Creators:
			final Collection<CreatorImpl> creatorImpls=article.getCreators();
			Assert.assertNotNull("The collection of article creators should not be null",creatorImpls);
			for(final CreatorImpl creator : creatorImpls) {
				Assert.assertNotNull("An article's creator should not be null",creator);
				Assert.assertNotNull("An article's creator id should not be null",creator.getId());
				Assert.assertNotNull("An article's creator name should not be null",creator.getName());
				Assert.assertFalse("An article's creator name should not be empty",creator.getName().isEmpty());
			}
			// Categories:
			final Collection<CategoryImpl> categoryImpls=article.getCategories();
			Assert.assertNotNull("The collection of article categories should not be null",categoryImpls);
			for(final CategoryImpl categoryImpl : categoryImpls) {
				Assert.assertNotNull("An article's category should not be null",categoryImpl);
				Assert.assertNotNull("An article's category id should not be null",categoryImpl.getId());
				Assert.assertNotNull("An article's category name should not be null",categoryImpl.getName());
				Assert.assertFalse("An article's category name should not be empty",categoryImpl.getName().isEmpty());
				Assert.assertNotNull("An article's category link should not be null",categoryImpl.getLink());
			}
			// Media:
			final Collection<MediumImpl> mediumImpls=article.getMedia();
			Assert.assertNotNull("The collection of article media should not be null",mediumImpls);
			for(final MediumImpl mediumImpl : mediumImpls) {
				Assert.assertNotNull("An article's medium should not be null",mediumImpl);
				Assert.assertNotNull("An article's medium link should not be null",mediumImpl.getLink());
				Assert.assertNotNull("An article's medium size should not be null",mediumImpl.getSize());
				Assert.assertNotNull("An article's medium type should not be null",mediumImpl.getType());
				Assert.assertNotNull("An article's medium type id should not be null",mediumImpl.getType().getId());
				Assert.assertNotNull("An article's medium type type should not be null",mediumImpl.getType().getType());
			}
		}
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
			public void notify(Feed<?,?,?,?,?,?> feed, Article<?,?,?,?,?> article) {
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
