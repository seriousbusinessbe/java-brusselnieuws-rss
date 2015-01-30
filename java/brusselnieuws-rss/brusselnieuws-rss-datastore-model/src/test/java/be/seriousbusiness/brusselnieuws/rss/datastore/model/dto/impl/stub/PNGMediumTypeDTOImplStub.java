package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.stub;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.MediumTypeDTOImpl;

/**
 * PNG image {@link MediumTypeDTOImpl} stub implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class PNGMediumTypeDTOImplStub extends MediumTypeDTOImpl {
	
	@Override
	public BigInteger getId() {
		return BigInteger.valueOf(123123123l);
	}

	@Override
	public String getType() {
		return "image/png";
	}

}
