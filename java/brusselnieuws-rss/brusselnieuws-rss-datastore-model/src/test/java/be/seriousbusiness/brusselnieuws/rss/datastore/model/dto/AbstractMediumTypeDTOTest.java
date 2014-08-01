package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Abstract Test Case for MediumTypeDTO implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link MediumTypeDTO} implementation
 */
public abstract class AbstractMediumTypeDTOTest<DTO extends MediumTypeDTO> extends AbstractIdDTOTest<Long,DTO> {
	private final String type;

	/**
	 * Create a new Test Case for MediumTypeDTO implementations.
	 * @paramm id a positive, non zero id
	 * @param type a valid non <code>null</code> type
	 */
	AbstractMediumTypeDTOTest(final long id,final String type) {
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
