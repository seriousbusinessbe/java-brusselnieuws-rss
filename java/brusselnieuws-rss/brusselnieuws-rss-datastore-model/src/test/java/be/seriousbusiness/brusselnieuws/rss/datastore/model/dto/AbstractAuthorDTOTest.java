package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Abstract Test Case for AuthorDTO implementations.
 * @author stefanborghys
 *
 * @param <AUTHORDTO> the type of {@link AuthorDTO} implementation
 */
public abstract class AbstractAuthorDTOTest<AUTHORDTO extends AuthorDTO> extends AbstractIdDTOTest<BigInteger,AUTHORDTO> {
	private final String name;

	/**
	 * Create a new Test Case for AuthorDTO implementations.
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
