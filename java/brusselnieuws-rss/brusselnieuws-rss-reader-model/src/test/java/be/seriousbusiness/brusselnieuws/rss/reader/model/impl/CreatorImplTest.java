package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.CreatorImplFactory;

/**
 * {@link CreatorImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CreatorImplTest {
	
	/**
	 * Tests if a clone of a given {@link CreatorImpl} is equal and non-equal after altering it.
	 * @param creatorImpl
	 */
	private static final void assertCloneable(final CreatorImpl creatorImpl) {
		final CreatorImpl clonedCreatorImpl=(CreatorImpl) creatorImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",creatorImpl,clonedCreatorImpl);
		clonedCreatorImpl.setName(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",creatorImpl,clonedCreatorImpl);
	}
	
	/**
	 * Tests if cloning a {@link CreatorImpl} works as expected.
	 */
	@Test
	public void testCloneable() {
		assertCloneable(CreatorImplFactory.createBrusselNieuws());
		assertCloneable(CreatorImplFactory.createNewBrusselNieuws());
	}

}
