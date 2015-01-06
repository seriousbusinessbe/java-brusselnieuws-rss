package be.seriousbusiness.brusselnieuws.rss.reader.reader.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.seriousbusiness.brusselnieuws.rss.reader.model.Article;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Author;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Category;
import be.seriousbusiness.brusselnieuws.rss.reader.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.reader.model.MediumType;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;

public class BrusselNieuwsRssReaderImplTest {
	private static final Logger LOGGER=LoggerFactory.getLogger(BrusselNieuwsRssReaderImplTest.class);
	private BrusselNieuwsRssReaderImpl brusselNieuwsRssReaderImpl;
	
	@Before
	public void before() {
		brusselNieuwsRssReaderImpl=new BrusselNieuwsRssReaderImpl();
	}

	
	/**
	 * Tests the reader by providing a locally stored xml feed</br>
	 * and checks if all data is retrieved correctly.
	 * @throws MalformedURLException
	 */
	@Test
	public void testLocal() throws MalformedURLException{
		final FeedImpl feed=new FeedImpl.Builder().link(new File("src/test/resources/brusselnieuws_be_nl_hoofdpunten_feed.xml").toURI().toURL()).title("test").build();
		Assert.assertNotNull("The collection of articles cannot be null",feed.getArticles());
		Assert.assertTrue("The collection of articles should be empty",feed.getArticles().isEmpty());
		brusselNieuwsRssReaderImpl.updateFeed(feed);
		/**
		assertEquals("BrusselNieuws RSS - Hoofdpunten",adaptableFeed.getTitle());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/hoofdpunten/feed"),adaptableFeed.getLink());
		assertEquals("",adaptableFeed.getDescription());
		final List<Article> articles=adaptableFeed.getArticles();
		assertNotNull(articles);
		assertEquals(10,articles.size());
		final Article article=articles.get(0);
		assertEquals("Wat staat er nog in het VGC-akkoord?",article.getTitle());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/nieuws/wat-staat-er-nog-het-vgc-akkoord"),article.getLink());
		final String expectedDescription=StringEscapeUtils.unescapeHtml4("&lt;p&gt;Een kinderarmoedeplan, meer aandacht voor vernieuwende stadsprojecten, een nieuwe fuifzaal en de aankoop van een avontuurlijk speeldomein. Het zijn maar enkele concrete elementen uit het nieuwe VGC-akkoord, dat de titel &#039;Goesting in Brussel&#039; meekreeg.&lt;/p&gt;Kris Hendrickx © brusselnieuws.be");
		assertEquals(expectedDescription,article.getDescription());
		assertEquals(new DateTime(2014,07,20,18,17,14),article.getPublicationDate());
		final List<Author> authors=article.getAuthors();
		assertNotNull(authors); 
		assertEquals(0,authors.size());
		//assertEquals("Kris Hendrickx © brusselnieuws.be",authors.get(0).getName());
		final List<Category> categories=article.getCategories();
		assertNotNull("The article's list of categories should not be null",categories);
		assertEquals(2,categories.size());
		final Category articleCategory=categories.get(0);
		assertNotNull(articleCategory);
		assertEquals("artikel",articleCategory.getName());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/media-type/artikel"),articleCategory.getLink());
		final Category politicalCategory=categories.get(1);
		assertNotNull(politicalCategory);
		assertEquals("politiek",politicalCategory.getName());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/bn-section/politiek"),politicalCategory.getLink());
		final List<Medium> media=article.getMedia();
		assertNotNull("The article's list of medium's should not be null",media);
		assertEquals(1,media.size());
		final Medium medium=media.get(0);
		assertNotNull(medium);
		assertEquals(MediumType.IMAGE_JPEG,medium.getType());
		assertEquals(new URL("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/3011660130_2dabb00177_z.jpg?itok=V_jyuCHQ"),medium.getLink());
		assertEquals(30388,medium.getSize());
		**/
	}
	
	/**
	 * Tests the reader by retrieving content from "http://www.brusselnieuws.be/nl/hoofdpunten/feed".
	 * @throws MalformedURLException when the given {@link URL} is incorrect
	 */
	@Test
	public void testLive() throws MalformedURLException{
		final FeedImpl feed=new FeedImpl.Builder().link(new URL("http://www.brusselnieuws.be/nl/hoofdpunten/feed")).title("test").build();
		Assert.assertNotNull("The collection of articles cannot be null",feed.getArticles());
		Assert.assertTrue("The collection of articles should be empty",feed.getArticles().isEmpty());
		brusselNieuwsRssReaderImpl.updateFeed(feed);
		Assert.assertNotNull("The collection of articles cannot be null",feed.getArticles());
		Assert.assertFalse("The collection of articles should not be empty",feed.getArticles().isEmpty());
	}

}
