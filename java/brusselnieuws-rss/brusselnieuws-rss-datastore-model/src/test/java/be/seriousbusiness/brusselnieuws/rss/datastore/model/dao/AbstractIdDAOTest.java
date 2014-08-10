package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * Abstract Test Case for {@link IdDAO} implementations.
 * @author stefanborghys
 *
 * @param <ID> the type of id
 * @param <DTO> the type of {@link IdDTO<ID>} used by the {@link IdDAO} implementation
 * @param <D> the type of {@link IdDAO<ID,DTO>} implementation under test
 */
public abstract class AbstractIdDAOTest<ID,DTO extends IdDTO<ID>,D extends IdDAO<ID,DTO>> extends AbstractDAOTest<DTO,D> {
	
	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNull("The created DTO id should be null",getDTO().getId());
	}
	
	/**
	 * Tests saving a newly created DTO and</br>
	 * retrieving it via it's id.
	 */
	@Test
	public void testFindById(){
		getDAO().save(getDTO());
		assertNotNull("The saved DTO id should not be null",getDTO().getId());
		final DTO dto=getDAO().findById(getDTO().getId());
		assertEquals("The saved DTO is not equal to the one found by it's id",dto,getDTO());
	}
	
	/**
	 * Test saving a newly created DTO.</br>
	 * After a successful save the ID should be set.</br>
	 * And the List of found {@link DTO} should return the saved DTO.
	 */
	@Override
	@Test 
	public void testSaveDTO(){
		getDAO().save(getDTO());
		assertNotNull("The saved DTO id should not be null",getDTO().getId());
		final List<DTO> dtos=getDAO().findAll();
		assertNotNull("The found list of DTO should not be null",dtos);
		assertEquals("The number of found DTO should be one",1,dtos.size());
		assertEquals("The found DTO is not equal to the one saved",getDTO(),dtos.get(0));
	}

}
