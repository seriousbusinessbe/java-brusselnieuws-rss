package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dao.util.DAOTestUtil;


/**
 * Defines {@link DAO} base tests.
 * @author stefanborghys
 *
 * @param <DTO> the type of DTO used by the {@link DAO} implementation
 * @param <D> the type of {@link DAO<DTO>} implementation under test
 */
public abstract class AbstractDAOTest<DTO,D extends DAO<DTO>> implements DAOTest<DTO,D> {
	private D dao;
	private DTO dto;
	
	@Override
	public abstract D createDAO();
	
	@Override
	public abstract DTO createDTO();
	
	/**
	 * Set up before every test case.</br>
	 * Creates a new {@link DAO} and {@link DTO}.
	 */
	@Before
	public void before(){
		dao=createDAO();
		assert dao!=null;
		dto=createDTO();
		assert dto!=null;
	}
	
	/**
	 * Tear down after every test case.</br>
	 * Delete's {@link DTO} if set.
	 */
	@After
	public void after(){
		dao.delete(dto);
	}
	
	@Override
	public D getDAO(){
		return dao;
	}
	
	@Override
	public DTO getDTO(){
		return dto;
	}
	
	@Override
	public void setDTO(final DTO dto){
		this.dto=dto;
	}
	
	/**
	 * Test if the created {@link DAO} is initialized as expected.
	 */
	@Test
	public void testGetDAO(){
		assertNotNull("The created DAO under test cannot be null",dao);
	}
	
	/**
	 * Test if the created {@link DTO} is initialized as expected.
	 */
	@Test
	public void testGetDTO(){
		assertNotNull("The created DTO under test cannot be null",dto);
	}
	
	/**
	 * Test saving a <code>null</code> value.</br>
	 * This should not throw an exception.</br>
	 * It should also never be saved.</br>
	 * The findAll() method should return an empty list of {@link DTO}.
	 */
	@Test
	public void testSaveNull(){
		dao.save(null);
		DAOTestUtil.assertFindAll(dao,0);
	}
	
	/**
	 * Test deleting a <code>null</code>.</br>
	 * This should not throw an exception.
	 */
	@Test
	public void testDeleteNull(){
		dao.delete(null);
	}
	
	/**
	 * Test saving a newly created {@link DTO}.</br>
	 * The list of found {@link DTO} should contain the saved DTO.
	 */
	@Test 
	public void testSaveDTO(){
		DAOTestUtil.assertFindAll(dao,0);
		setDTO(dao.save(dto));
		assertEquals("The found DTO is not equal to the one saved",dto,DAOTestUtil.assertFindAll(dao,1).get(0));
	}
	
	/**
	 * Test deleting a saved {@link DTO}.
	 */
	@Test
	public void testDeleteDTO(){
		DAOTestUtil.assertFindAll(dao,0);
		setDTO(dao.save(dto));
		DAOTestUtil.assertFindAll(dao,1);
		dao.delete(dto);
		DAOTestUtil.assertFindAll(dao,0);
	}
	
	/**
	 * Test the {@link #findAll() findAll()}, before and after saving a {@link DTO}.</br>
	 * Before saving, no {@link DTO} should be found.</br>
	 * After saving, one {@link DTO} should be found.
	 */
	@Test 
	public void testFindAll(){
		DAOTestUtil.assertFindAll(dao,0);
		setDTO(dao.save(dto));
		assertEquals("The found DTO is not equal to the one saved",dto,DAOTestUtil.assertFindAll(dao,1).get(0));
	}

}
