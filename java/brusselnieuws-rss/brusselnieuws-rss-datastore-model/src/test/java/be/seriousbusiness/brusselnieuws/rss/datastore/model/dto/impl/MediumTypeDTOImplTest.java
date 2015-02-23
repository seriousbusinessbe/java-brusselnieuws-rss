package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumTypeDTOTest;

/**
 * {@link MediumTypeDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumTypeDTOImplTest extends AbstractMediumTypeDTOTest<MediumTypeDTOImpl> {

	public MediumTypeDTOImplTest() {
		super(BigInteger.valueOf(123456789l),"image/jpeg");
	}

	@Override
	public MediumTypeDTOImpl create() {
		return new MediumTypeDTOImpl.Builder().build();
	}
	
	@Ignore
	@Test
	public void testCloneable() {
		final MediumTypeDTOImpl clonedMediumTypeDTOImpl=(MediumTypeDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedMediumTypeDTOImpl);
		clonedMediumTypeDTOImpl.setType(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedMediumTypeDTOImpl);
	}

}
