package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.model.Author;
import be.seriousbusiness.brusselnieuws.rss.model.Category;
import be.seriousbusiness.brusselnieuws.rss.model.Medium;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleAuthorMock;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleCategoryMock;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleMediumMock;


public abstract class AbstractAdaptableArticleTest<A extends AdaptableArticle> extends AbstractAdaptableContentTest<Long,A> {

	/**
	 * Test if a <code>null</code> author is not added.
	 */
	@Test
	public void testAddNullAuthor(){
		final int numberOfAuthors=adaptable.numberOfAuthors();
		adaptable.add((Author)null);
		Assert.assertEquals("The number of authors should not have changed after adding null",numberOfAuthors,adaptable.numberOfAuthors(),0.0);
		Assert.assertFalse("The article should not have a null author",adaptable.hasAuthor(null));
	}
	
	/**
	 * Test if adding a new author works.
	 */
	@Test
	public void testAddAuthor(){
		final int numberOfAuthors=adaptable.numberOfAuthors();
		final Author author=new SimpleAuthorMock();
		adaptable.add(author);
		Assert.assertEquals("The number of authors should have increased",numberOfAuthors+1,adaptable.numberOfAuthors(),0.0);
		Assert.assertTrue("The article should have the new author",adaptable.hasAuthor(author));
	}
	
	/**
	 * Test if a <code>null</code> category is not added.
	 */
	@Test
	public void testAddNullCategory(){
		final int numberOfCategories=adaptable.numberOfCategories();
		adaptable.add((Category)null);
		Assert.assertEquals("The number of categories should not have changed after adding null",numberOfCategories,adaptable.numberOfCategories(),0.0);
		Assert.assertFalse("The article should not have a null category",adaptable.hasCategory(null));
	}
	
	/**
	 * Test if adding a new category works.
	 */
	@Test
	public void testAddCategory(){
		final int numberOfCategories=adaptable.numberOfCategories();
		final Category category=new SimpleCategoryMock();
		adaptable.add(category);
		Assert.assertEquals("The number of categories should have increased",numberOfCategories+1,adaptable.numberOfCategories(),0.0);
		Assert.assertTrue("The article should have the new category",adaptable.hasCategory(category));
	}
	
	/**
	 * Test if a <code>null</code> medium is not added.
	 */
	@Test
	public void testAddNullMedium(){
		final int numberOfMedia=adaptable.numberOfMedia();
		adaptable.add((Medium)null);
		Assert.assertEquals("The number of categories should not have changed after adding null",numberOfMedia,adaptable.numberOfMedia(),0.0);
	}
	
	/**
	 * Test if adding a medium works.
	 */
	@Test
	public void testAddMedium(){
		final int numberOfMedia=adaptable.numberOfMedia();
		final Medium medium=new SimpleMediumMock();
		adaptable.add(medium);
		Assert.assertEquals("The number of media should have increased",numberOfMedia+1,adaptable.numberOfMedia(),0.0);
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
	
	@Test
	public void testFavorite(){
		assertFalse("The article should not be set favorite by default",adaptable.isFavorite());
		adaptable.setFavorite(false);
		assertFalse("The article should not be set favorite",adaptable.isFavorite());
		adaptable.setFavorite(true);
		assertTrue("The article should be set as favorite",adaptable.isFavorite());
	}

}
