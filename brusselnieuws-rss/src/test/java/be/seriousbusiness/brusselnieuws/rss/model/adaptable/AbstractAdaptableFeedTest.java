package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleArchivedArticleMock;
import be.seriousbusiness.brusselnieuws.rss.model.SimpleArticleMock;

public abstract class AbstractAdaptableFeedTest<F extends AdaptableFeed> extends AbstractAdaptableContentTest<F> {
	
	/**
	 * Creates a new AdaptableFeed implementation under test,</br>
	 * before every test
	 */
	@Before
	public abstract void before();
	
	/**
	 * Test if a <code>null</code> article is not added.
	 */
	@Test
	public void testAddNull(){
		final int size=adaptable.size();
		adaptable.add(null);
		assertEquals("The feed size should not have changed after adding null",size,adaptable.size(),0.0);
		assertFalse("The feed should not have a null article",adaptable.hasArticle(null));
	}
	
	/**
	 * Test if adding a new article works.
	 */
	@Test
	public void testAdd(){
		final int size=adaptable.size();
		final Article article=new SimpleArticleMock();
		adaptable.add(article);
		assertEquals("The feed size should have increased",size+1,adaptable.size(),0.0);
		assertTrue("The feed should have the new article",adaptable.hasArticle(article));
		assertEquals("The added article should be returned",article,adaptable.add(article));
	}
	
	@Test
	public void testGetArticlesArchived() throws InterruptedException{
		List<Article> archivedArticles=adaptable.getArticles(true),notArchivedArticles=adaptable.getArticles(false);
		assertNotNull("The list of archived articles should not be null",archivedArticles);
		assertNotNull("The list of not archived articles should not be null",notArchivedArticles);
		assertEquals("The list of archived articles should be empty",0,archivedArticles.size());
		assertEquals("The list of not archived articles should be empty",0,notArchivedArticles.size());
		final Article simpleArticle=new SimpleArticleMock(),
				archivedArticle1=new SimpleArchivedArticleMock();
		Thread.sleep(1000); // Sleep for 1 seconc, so both SimpleArchivedArticleMocks have a different publication time which will make them unique
		final Article archivedArticle2=new SimpleArchivedArticleMock();
		adaptable.add(simpleArticle);
		adaptable.add(archivedArticle1);
		adaptable.add(archivedArticle2);
		archivedArticles=adaptable.getArticles(true);
		notArchivedArticles=adaptable.getArticles(false);
		assertNotNull("The list of archived articles should not be null",archivedArticles);
		assertNotNull("The list of not archived articles should not be null",notArchivedArticles);
		assertEquals("The number of archived articles is incorrect",2,archivedArticles.size());
		assertEquals("The list of archived articles is not ordered by publication date",archivedArticle2,archivedArticles.get(0));
		assertEquals("The list of archived articles is not ordered by publication date",archivedArticle1,archivedArticles.get(1));
		assertEquals("The number of not archived articles is incorrect",1,notArchivedArticles.size());
		assertEquals("",simpleArticle,notArchivedArticles.get(0));
	}

}
