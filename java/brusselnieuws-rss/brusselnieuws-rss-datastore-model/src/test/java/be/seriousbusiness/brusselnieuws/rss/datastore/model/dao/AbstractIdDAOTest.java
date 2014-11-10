package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.util.DAOTestUtil;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.IdDTO;

/**
 * Abstract Test Case for {@link IdDAO} implementations.
 * @author stefanborghys
 *
 * @param <ID> the type of id
 * @param <IDDTO> the type of {@link IdDTO<ID>} used by the {@link IdDAO} implementation
 * @param <IDDAO> the type of {@link IdDAO<ID,DTO>} implementation under test
 */
public abstract class AbstractIdDAOTest<ID,
										IDDTO extends IdDTO<ID>,
										IDDAO extends IdDAO<ID,IDDTO>> extends AbstractDAOTest<IDDTO,IDDAO> {
	
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
		setDTO(getDAO().save(getDTO()));
		assertNotNull("The saved DTO id should not be null",getDTO().getId());
		assertEquals("The saved DTO is not equal to the one found by it's id",getDTO(),getDAO().findById(getDTO().getId()));
	}
	
	/**
	 * Test finding a {@link DTO} by <code>null</code> id.</br>
	 * This should not fail but always return <code>null</code>.
	 */
	@Test
	public void testFindByIdNull(){
		assertNull("Finding a DTO by null id should return null",getDAO().findById(null));
	}
	
	/**
	 * Test saving a newly created DTO.</br>
	 * After a successful save the ID should be set.</br>
	 * And the List of found {@link IDDTO} should return the saved DTO.
	 */
	@Override
	@Test 
	public void testSaveDTO(){
		DAOTestUtil.assertFindAll(getDAO(),0);
		setDTO(getDAO().save(getDTO()));
		assertNotNull("The saved DTO id should not be null",getDTO().getId());
		assertEquals("The found DTO is not equal to the one saved",getDTO(),DAOTestUtil.assertFindAll(getDAO(),1).get(0));
	}

}
