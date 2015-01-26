package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.stub;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumTypeDTO;

/**
 * {@link MediumTypeDTO} stub implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class MediumTypeDTOStub implements MediumTypeDTO {

	@Override
	public BigInteger getId() {
		return BigInteger.valueOf(123123123l);
	}

	@Override
	public void setId(final BigInteger id) {}

	@Override
	public String getType() {
		return "image/png";
	}

	@Override
	public void setType(final String type) {}

}
