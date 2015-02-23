package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractCreatorDTOTest;

/**
 * {@link CreatorDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class CreatorDTOImplTest extends AbstractCreatorDTOTest<CreatorDTOImpl> {
	
	public CreatorDTOImplTest() {
		super(BigInteger.valueOf(5462424344l),"© FM Brussel");
	}

	@Override
	public CreatorDTOImpl create() {
		return new CreatorDTOImpl.Builder().build();
	}
	
}
