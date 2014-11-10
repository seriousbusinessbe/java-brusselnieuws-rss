package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractMediumTypeDTOTest;

public class MediumTypeDTOImplTest extends AbstractMediumTypeDTOTest<MediumTypeDTOImpl> {

	public MediumTypeDTOImplTest() {
		super(BigInteger.valueOf(123456789l),"image/jpeg");
	}

	@Override
	public MediumTypeDTOImpl create() {
		return new MediumTypeDTOImpl();
	}

}
