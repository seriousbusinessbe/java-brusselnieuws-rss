package be.seriousbusiness.brusselnieuws.rss.model.adaptable.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleAuthorMock;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleCategoryMock;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleMediumMock;
import be.seriousbusiness.brusselnieuws.rss.model.adaptable.AbstractAdaptableArticleTest;

public class AdaptableArticleImplTest extends AbstractAdaptableArticleTest<AdaptableArticleImpl> {

	@Override
	public void before() {
		adaptable=new AdaptableArticleImpl.Builder().title("Test title").build();
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
		final DateTime publicationDate=DateTime.now();
		final Author author=new SimpleAuthorMock();
		final Medium medium=new SimpleMediumMock();
		final Category category=new SimpleCategoryMock();
		final boolean read=true,archived=false;
		final Article article=new AdaptableArticleImpl.Builder().
				title(title).
				description(description).
				link(link).
				publicationDate(publicationDate).
				add(author).
				add(medium).
				add(category).
				read(read).
				archive(archived).
				build();
		assertEquals("The title is not set",title,article.getTitle());
		assertEquals("The description is not set",description,article.getDescription());
		assertEquals("The link is not set",link,article.getLink());
		assertEquals("The publication date is not set",publicationDate,article.getPublicationDate());
		final List<Author> authors=article.getAuthors();
		assertNotNull("The list of authors is null",authors);
		assertEquals("The number of authors should be one",1,authors.size());
		assertEquals("The retrieved author is not equal to the one set",author,authors.get(0));
		final List<Category> categories=article.getCategories();
		assertNotNull("The list of categories is null",categories);
		assertEquals("The number of categories should be one",1,categories.size());
		assertEquals("The retrieved category is not equal to the one set",category,categories.get(0));
		final List<Medium> media=article.getMedia();
		assertNotNull("The list of mediums is null",media);
		assertEquals("The number of mediums should be one",1,media.size());
		assertEquals("The retrieved medium is not equal to the one set",medium,media.get(0));
		assertEquals("The article is not set read",read,article.isRead());
		assertEquals("The article should not be archived",archived,article.isArchived());
	}
	
	@Test
	public void testRead(){
		assertFalse("The article should not be set read by default",adaptable.isRead());
		adaptable.read();
		assertTrue("The article should be set read",adaptable.isRead());
	}
	
	@Test
	public void testArchive(){
		assertFalse("The article should not be set archived by default",adaptable.isArchived());
		adaptable.archive();
		assertTrue("The article should be set archived",adaptable.isArchived());
	}

}
