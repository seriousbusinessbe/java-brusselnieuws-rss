package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumTypeDTOTest;

/**
 * {@link MediumTypeDTOImpl test implementation.
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
		return new MediumTypeDTOImpl();
	}

}
