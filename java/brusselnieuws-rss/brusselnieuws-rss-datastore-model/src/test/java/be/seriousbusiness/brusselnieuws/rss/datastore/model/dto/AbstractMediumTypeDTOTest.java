package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;

import org.junit.Test;

/**
 * Abstract Test Case for MediumTypeDTO implementations.
 * @author stefanborghys
 *
 * @param <MEDIUMTYPEDTO> the type of {@link MediumTypeDTO} implementation
 */
public abstract class AbstractMediumTypeDTOTest<MEDIUMTYPEDTO extends MediumTypeDTO> extends AbstractIdDTOTest<BigInteger,MEDIUMTYPEDTO> {
	private final String type;

	/**
	 * Create a new Test Case for MediumTypeDTO implementations.
	 * @param id a positive, non zero id
	 * @param type a valid non <code>null</code> type
	 */
	public AbstractMediumTypeDTOTest(final BigInteger id,final String type) {
		super(id);
		this.type=type;
	}
	
	@Test 
	@Override
	public void test(){
		super.test();
		assertNull("The type should be null",getDTO().getType());
	}
	
	@Test 
	@Override
	public void testGettersAndSetters(){
		getDTO().setType(type);
		assertEquals("The retrieved type is not equal to the one set",type,getDTO().getType());
	}

}
