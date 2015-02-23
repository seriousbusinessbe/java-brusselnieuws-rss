package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractCategoryDTOTest;

/**
 * {@link CategoryDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CategoryDTOImplTest extends AbstractCategoryDTOTest<CategoryDTOImpl> {

	public CategoryDTOImplTest() {
		super(BigInteger.valueOf(321321321l),"http://www.brusselnieuws.be/nl/media-type/artikel","artikel");
	}

	@Override
	public CategoryDTOImpl create() {
		return new CategoryDTOImpl.Builder().build();
	}
	
	@Ignore
	@Test
	public void testCloneable() {
		final CategoryDTOImpl clonedCategoryDTOImpl=(CategoryDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedCategoryDTOImpl);
		clonedCategoryDTOImpl.setName(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedCategoryDTOImpl);
	}

}
