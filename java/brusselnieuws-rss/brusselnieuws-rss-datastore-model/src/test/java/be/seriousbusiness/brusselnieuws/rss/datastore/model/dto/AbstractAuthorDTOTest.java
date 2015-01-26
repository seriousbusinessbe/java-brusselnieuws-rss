package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Abstract test case for {@link AuthorDTO} implementations.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <AUTHORDTO> the type of {@link AuthorDTO} implementation
 */
public abstract class AbstractAuthorDTOTest<AUTHORDTO extends AuthorDTO> extends AbstractIdDTOTest<BigInteger,AUTHORDTO> {
	private final String name;

	/**
	 * Create a new test case for {@link AuthorDTO} implementations.
	 * @param id a positive, non zero id
	 * @param name a valid non <code>null</code> link
	 */
	public AbstractAuthorDTOTest(final BigInteger id,final String name) {
		super(id);
		this.name=name;
	}

	@Test 
	@Override
	public void test(){
		super.test();
		assertNull("The name should be null",getDTO().getName());
	}
	
	@Test 
	@Override
	public void testGettersAndSetters(){
		getDTO().setName(name);
		assertEquals("The retrieved name is not equal to the one set",name,getDTO().getName());
	}

}
