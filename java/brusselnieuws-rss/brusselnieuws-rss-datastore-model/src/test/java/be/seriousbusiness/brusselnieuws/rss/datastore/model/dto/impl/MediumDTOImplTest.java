package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumDTOTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.MediumTypeDTOImplFactory;

/**
 * {@link MediumDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumDTOImplTest extends AbstractMediumDTOTest<MediumTypeDTOImpl,MediumDTOImpl> {

	public MediumDTOImplTest() {
		super("http://www.brusselnieuws.be/sites/default/files/styles/bn_220_crop/public/article_media/image/kermis02.jpg?itok=8fRRYMA1",
				MediumTypeDTOImplFactory.createPNG(),31478l);
	}

	@Override
	public MediumDTOImpl create() {
		return new MediumDTOImpl.Builder().build();
	}
	
	@Ignore
	@Test
	public void testCloneable() {
		// Alter clone:
		MediumDTOImpl clonedMediumDTOImpl=(MediumDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedMediumDTOImpl);
		clonedMediumDTOImpl.setSize(System.currentTimeMillis());
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedMediumDTOImpl);
		// Alter clone's nested {@link MediumTypeDTOImpl}:
		clonedMediumDTOImpl=(MediumDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedMediumDTOImpl);
		clonedMediumDTOImpl.getMediumTypeDTO().setType(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedMediumDTOImpl);
	}

}
