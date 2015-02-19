package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;

import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.MediumImplFactory;

/**
 * {@link MediumImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumImplTest {
	
	/**
	 * Tests if a clone of a given {@link MediumImpl} is equal and non-equal after altering it.
	 * @param mediumImpl
	 */
	private static final void assertCloneable(final MediumImpl mediumImpl) {
		// Alter clone:
		MediumImpl clonedMediumImpl=(MediumImpl) mediumImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",mediumImpl,clonedMediumImpl);
		clonedMediumImpl.setSize(System.currentTimeMillis());
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",mediumImpl,clonedMediumImpl);
		// Alter clone's nested {@link MediumTypeImpl}:
		clonedMediumImpl=(MediumImpl) mediumImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",mediumImpl,clonedMediumImpl);
		clonedMediumImpl.getType().setType(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",mediumImpl,clonedMediumImpl);
	}
	
	/**
	 * Tests if cloning a {@link MediumImpl} works as expected.
	 */
	@Test
	public void testCloneable() {
		assertCloneable(MediumImplFactory.createPNG());
		assertCloneable(MediumImplFactory.createNewJPEG());
	}

}
