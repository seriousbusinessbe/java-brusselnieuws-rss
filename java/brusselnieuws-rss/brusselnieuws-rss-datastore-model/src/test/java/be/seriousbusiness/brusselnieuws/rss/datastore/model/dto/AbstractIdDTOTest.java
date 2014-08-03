package be.seriousbusiness.brusselnieuws.rss.datastore.model.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Abstract Test Case for IdDTO implementations.
 * @author stefanborghys
 *
 * @param <ID> the type of id
 * @param <DTO> the type of {@link IdDTO<ID>} implementation
 */
public abstract class AbstractIdDTOTest<ID,DTO extends IdDTO<ID>> implements DTOTest<DTO> {
	private DTO dto;
	private final ID id;
	
	/**
	 * Create a new Test Case for IdDTO implementations.
	 * @param id a valid non <code>null</code> id
	 */
	AbstractIdDTOTest(final ID id){
		this.id=id;
	}
		
	@Override
	public abstract DTO create();
	
	@Override
	public DTO getDTO(){
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
