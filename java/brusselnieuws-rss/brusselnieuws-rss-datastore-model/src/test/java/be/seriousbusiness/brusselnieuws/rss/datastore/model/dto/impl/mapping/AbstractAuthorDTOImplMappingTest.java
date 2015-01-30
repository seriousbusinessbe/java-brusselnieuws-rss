package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.mapping;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.AuthorDTOImplFactory;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.mapping.AbstractMappingTest;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.util.AuthorDTOUtil;

/**
 * Abstract {@link AuthorDTOImpl} mapping test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <A> the type of {@link AuthorDTO} to perform a mapping test against
 */
public abstract class AbstractAuthorDTOImplMappingTest<A extends AuthorDTO> extends AbstractMappingTest<AuthorDTO,A,AuthorDTOImpl> {

	@Override
	protected AuthorDTOImpl createDTOB() {
		return AuthorDTOImplFactory.createErikaVlieghe();
	}

	@Override
	protected void assertEquals(final A dtoA,final AuthorDTOImpl dtoB) {
		AuthorDTOUtil.assertEquals(dtoA, dtoB);
	}

}
