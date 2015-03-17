package be.seriousbusiness.brusselnieuws.rss.reader.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.ArticleImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.AuthorImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.CategoryImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.FeedImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.MediumImpl;
import be.seriousbusiness.brusselnieuws.rss.reader.reader.impl.BrusselNieuwsRssReaderImpl;

/**
 * {@link BrusselNieuwsRssReaderImpl} test case implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class BrusselNieuwsRssReaderImplTest {
	private BrusselNieuwsRssReaderImpl brusselNieuwsRssReaderImpl;
	
	@Before
	public void before() {
		brusselNieuwsRssReaderImpl=new BrusselNieuwsRssReaderImpl();
	}

	
	/**
	 * Tests the {@link BrusselNieuwsRssReaderImpl} by providing a locally stored xml feed</br>
	 * and checks if all data is retrieved correctly.
	 * @throws MalformedURLException
	 */
	@Test
	public void testLocal() throws MalformedURLException{
		final FeedImpl feed=new FeedImpl.Builder().link(new File("src/test/resources/data/brusselnieuws_be_nl_hoofdpunten_feed.xml").toURI().toURL()).title("test").build();
		Assert.assertNotNull("The collection of articles cannot be null",feed.getArticles());
		Assert.assertTrue("The collection of articles should be empty",feed.getArticles().isEmpty());
		brusselNieuwsRssReaderImpl.updateFeed(feed);
		assertEquals("BrusselNieuws RSS - Hoofdpunten",feed.getTitle());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/hoofdpunten/feed"),feed.getLink());
		assertNull(feed.getDescription());
		final Collection<ArticleImpl> articles=feed.getArticles();
		assertNotNull(articles);
		assertEquals(10,articles.size());
		final ArticleImpl article=new ArrayList<ArticleImpl>(articles).get(0);
		assertEquals("Wat staat er nog in het VGC-akkoord?",article.getTitle());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/nieuws/wat-staat-er-nog-het-vgc-akkoord"),article.getLink());
		final String expectedDescription=StringEscapeUtils.unescapeHtml4("Een kinderarmoedeplan, meer aandacht voor vernieuwende stadsprojecten, een nieuwe fuifzaal en de aankoop van een avontuurlijk speeldomein. Het zijn maar enkele concrete elementen uit het nieuwe VGC-akkoord, dat de titel &#039;Goesting in Brussel&#039; meekreeg.Kris Hendrickx © brusselnieuws.be");
		assertEquals(expectedDescription,article.getDescription());
		assertEquals(new DateTime(2014,07,20,18,17,14),article.getPublicationDate());
		final Collection<AuthorImpl> authors=article.getAuthors();
		assertNotNull(authors); 
		assertEquals(0,authors.size());
		//assertEquals("Kris Hendrickx © brusselnieuws.be",authors.get(0).getName());
		final Collection<CategoryImpl> categories=article.getCategories();
		assertNotNull("The article's list of categories should not be null",categories);
		assertEquals(2,categories.size());
		final List<CategoryImpl> categoryList=new ArrayList<CategoryImpl>(categories);
		final CategoryImpl articleCategory=categoryList.get(0);
		assertNotNull(articleCategory);
		assertEquals("artikel",articleCategory.getName());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/media-type/artikel"),articleCategory.getLink());
		final CategoryImpl politicalCategory=categoryList.get(1);
		assertNotNull(politicalCategory);
		assertEquals("politiek",politicalCategory.getName());
		assertEquals(new URL("http://www.brusselnieuws.be/nl/bn-section/politiek"),politicalCategory.getLink());
		final Collection<MediumImpl> media=article.getMedia();
		assertNotNull("The article's list of medium's should not be null",media);
		assertEquals(2,media.size());
		final MediumImpl medium=new ArrayList<MediumImpl>(media).get(0);
		assertNotNull(medium);
		assertEquals("image/jpeg",medium.getType().getType());
		assertNotNull(medium.getLink());
		assertFalse(medium.getLink().toString().isEmpty());
		// TODO: a second medium is created when found, testing needs to take this into account!
		//assertEquals(new URL("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/images/3011660130_2dabb00177_z.jpg?itok=V_jyuCHQ"),medium.getLink());
		assertNotNull(medium.getSize());
		assertTrue(medium.getSize()>0);
		//assertEquals(30388,medium.getSize());
	}
	
	/**
	 * Tests the {@link BrusselNieuwsRssReaderImpl} by retrieving live content from <a href="http://www.brusselnieuws.be/nl/hoofdpunten/feed">http://www.brusselnieuws.be/nl/hoofdpunten/feed</a>.
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
