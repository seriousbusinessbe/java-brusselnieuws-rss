package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AbstractAuthorDTOTest;

/**
 * {@link AuthorDTOImpl} test implementation.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 */
public class AuthorDTOImplTest extends AbstractAuthorDTOTest<AuthorDTOImpl> {

	public AuthorDTOImplTest() {
		super(BigInteger.valueOf(121121121l),"© brusselnieuws.be");
	}

	@Override
	public AuthorDTOImpl create() {
		return new AuthorDTOImpl.Builder().build();
	}
	
	@Ignore
	@Test
	public void testCLoneable() {
		final AuthorDTOImpl clonedAuthorDTOImpl=(AuthorDTOImpl) getDTO().clone();
		Assert.assertEquals("The clone should be equal to the one it's cloned from",getDTO(),clonedAuthorDTOImpl);
		clonedAuthorDTOImpl.setName(String.valueOf(System.currentTimeMillis()));
		Assert.assertNotEquals("The clone should not be equal to the one it's cloned from after altering it",getDTO(),clonedAuthorDTOImpl);
	}

}
