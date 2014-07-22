package be.seriousbusiness.brusselnieuws.rss.model.adaptable;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.model.Article;
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
		Assert.assertEquals("The feed size should not have changed after adding null",size,adaptable.size(),0.0);
		Assert.assertFalse("The feed should not have a null article",adaptable.hasArticle(null));
	}
	
	/**
	 * Test if adding a new article works.
	 */
	@Test
	public void testAdd(){
		final int size=adaptable.size();
		final Article article=new SimpleArticleMock();
		adaptable.add(article);
		Assert.assertEquals("The feed size should have increased",size+1,adaptable.size(),0.0);
		Assert.assertTrue("The feed should have the new article",adaptable.hasArticle(article));
	}

}
