package be.seriousbusiness.brusselnieuws.rss.reader.model.impl;


import org.junit.Assert;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.reader.model.impl.factory.MediumTypeImplFactory;

/**
 * {@link MediumTypeImpl} test case.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumTypeImplTest {
	
	/**
	 * Tests if a clone of a given {@link MediumTypeImpl} is equal and non-equal after altering it.
	 * @param mediumTypeImpl
	 */
	private static final void assertCloneable(final MediumTypeImpl mediumTypeImpl) {
		final MediumTypeImpl clonedMediumTypeImpl=(MediumTypeImpl) mediumTypeImpl.clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",mediumTypeImpl,clonedMediumTypeImpl);
		clonedMediumTypeImpl.setType(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",mediumTypeImpl,clonedMediumTypeImpl);
	}
	
	/**
	 * Tests if cloning a {@link MediumTypeImpl} works as expected.
	 */
	@Test
	public void testCloneable() {
		assertCloneable(MediumTypeImplFactory.createJPEG());
		assertCloneable(MediumTypeImplFactory.createNewPNG());
	}

}
