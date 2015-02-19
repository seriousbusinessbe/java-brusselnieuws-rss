package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.AuthorImplFactory;

/**
 * {@link AuthorImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class AuthorImplTest {
	
	/**
	 * Tests if a clone of a given {@link AuthorImpl} is equal and non-equal after altering it.
	 * @param authorImpl
	 */
	private static final void assertCloneable(final AuthorImpl authorImpl) {
		final AuthorImpl clonedAuthorImpl=(AuthorImpl) authorImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",authorImpl,clonedAuthorImpl);
		clonedAuthorImpl.setName(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",authorImpl,clonedAuthorImpl);
	}
	
	/**
	 * Tests if cloning a {@link AuthorImpl} works as expected.
	 */
	@Test
	public void testCloneable() {
		assertCloneable(AuthorImplFactory.createBrusselNieuws());
		assertCloneable(AuthorImplFactory.createNewBrusselNieuws());
	}

}
