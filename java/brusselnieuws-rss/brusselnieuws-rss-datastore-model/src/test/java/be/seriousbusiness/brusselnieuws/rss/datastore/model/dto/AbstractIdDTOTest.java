package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Abstract Test Case for {@link IdDTO} implementations.
 * @author Serious Business
 * @author Stefan Borghys
 * @version 1.0
 * @since 1.0
 * @param <ID> the type of id
 * @param <IDDTO> the type of {@link IdDTO<ID>} implementation
 */
public abstract class AbstractIdDTOTest<ID,IDDTO extends IdDTO<ID>> implements DTOTest<IDDTO> {
	private IDDTO dto;
	private final ID id;
	
	/**
	 * Creates a new Test Case for {@link IdDTO} implementations.
	 * @param id a valid non <code>null</code> id
	 */
	AbstractIdDTOTest(final ID id){
		this.id=id;
	}
		
	@Override
	public abstract IDDTO create();
	
	@Override
	public IDDTO getDTO(){
		return dto;
	}
	
	@Before 
	public void before(){
		dto=create();
	}
	
	@Test 
	@Override
	public void test(){
		assertNull("The id should be null",dto.getId());
	}
	
	@Test 
	@Override
	public void testGettersAndSetters(){
		dto.setId(id);
		assertEquals("The retrieved id is not equal to the one set",id,dto.getId());
	}

}
