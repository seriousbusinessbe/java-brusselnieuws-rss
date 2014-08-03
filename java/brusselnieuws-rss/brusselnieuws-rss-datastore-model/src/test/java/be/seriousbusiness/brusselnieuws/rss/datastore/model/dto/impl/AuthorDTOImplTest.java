package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractAuthorDTOTest;

public class AuthorDTOImplTest extends AbstractAuthorDTOTest<AuthorDTOImpl> {

	public AuthorDTOImplTest() {
		super(121121121l,"© brusselnieuws.be");
	}

	@Override
	public AuthorDTOImpl create() {
		return new AuthorDTOImpl();
	}

}
