package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.CategoryImplFactory;

/**
 * {@link CategoryImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryImplTest {
	
	/**
	 * Tests if a clone of a given {@link CategoryImpl} is equal and non-equal after altering it.
	 * @param categoryImpl
	 */
	private static final void assertCloneable(final CategoryImpl categoryImpl) {
		final CategoryImpl clonedCategoryImpl=(CategoryImpl) categoryImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",categoryImpl,clonedCategoryImpl);
		clonedCategoryImpl.setName(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",categoryImpl,clonedCategoryImpl);
	}
	
	/**
	 * Tests if cloning a {@link CategoryImpl} works as expected.
	 * @throws MalformedURLException 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void testCloneable() throws IllegalArgumentException, MalformedURLException {
		assertCloneable(CategoryImplFactory.createArtikel());
		assertCloneable(CategoryImplFactory.createNewArtikel());
	}

}
