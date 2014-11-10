package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractAuthorDTOTest;

public class AuthorDTOImplTest extends AbstractAuthorDTOTest<AuthorDTOImpl> {

	public AuthorDTOImplTest() {
		super(BigInteger.valueOf(121121121l),"© brusselnieuws.be");
	}

	@Override
	public AuthorDTOImpl create() {
		return new AuthorDTOImpl();
	}

}
