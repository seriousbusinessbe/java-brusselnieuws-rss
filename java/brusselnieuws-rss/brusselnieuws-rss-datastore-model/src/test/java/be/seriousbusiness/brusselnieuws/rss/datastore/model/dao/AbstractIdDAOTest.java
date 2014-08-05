package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;



import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

public abstract class AbstractIdDAOTest<ID,DTO extends IdDTO<ID>,D extends IdDAO<ID,DTO>> extends AbstractDAOTest<DTO,D> {

	@Override
	@Test
	public void assertDAODTO(){
		super.assertDAODTO();
		assertNull("The created DTO id should be null",getDTO().getId());
	}
	
	/**
	 * Tests saving a newly created DTO and</br>
	 * retrieving it via it's id.
	 */
	@Test
	public void testFindById(){
		assertDAODTO();
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
	public void saveDTO(){
		assertDAODTO();
		getDAO().save(getDTO());
		assertNotNull("The saved DTO id should not be null",getDTO().getId());
		final List<DTO> dtos=getDAO().findAll();
		assertNotNull("The found list of DTO should not be null",dtos);
		assertEquals("The number of found DTO should be one",1,dtos.size());
		assertEquals("The found DTO is not equal to the one saved",getDTO(),dtos.get(0));
	}

}
