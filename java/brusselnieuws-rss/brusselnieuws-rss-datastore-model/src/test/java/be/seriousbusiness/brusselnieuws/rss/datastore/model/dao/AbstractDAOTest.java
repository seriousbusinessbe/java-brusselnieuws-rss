package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


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
	
	@Before
	public void before(){
		dao=createDAO();
		assert(dao!=null);
		dto=createDTO();
		assert(dto!=null);
	}
	
	@Override
	public D getDAO(){
		return dao;
	}
	
	@Override
	public DTO getDTO(){
		return dto;
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
	 * This should not throw an Exception.</br>
	 * It should also never be saved.</br>
	 * The findAll() method should return an empty list of {@link DTO}.
	 */
	@Test
	public void testSaveNull(){
		dao.save(null);
		final List<DTO> dtos=dao.findAll();
		assertNotNull("The found list of DTO should not be null",dtos);
		assertEquals("The found list of DTO should be empy",0,dtos.size());
	}
	
	/**
	 * Test saving a newly created {@link DTO}.</br>
	 * The list of found {@link DTO} should contain the saved DTO.
	 */
	@Test 
	public void testSaveDTO(){
		dao.save(dto);
		final List<DTO> dtos=dao.findAll();
		assertNotNull("The found list of DTO should not be null",dtos);
		assertEquals("The number of found DTO should be one",1,dtos.size());
		assertEquals("The found DTO is not equal to the one saved",dto,dtos.get(0));
	}
	
	/**
	 * Test the findAll() method, before and after saving a {@link DTO}.
	 */
	@Test 
	public void testFindAll(){
		List<DTO> dtos=dao.findAll();
		assertNotNull("The found list of DTO should be empty by default",dtos);
		assertEquals("The found list of DTO should be empty by default",0,dtos.size());
		dao.save(dto);
		dtos=dao.findAll();
		assertNotNull("After saving a DTO the found list should not be null",dtos);
		assertEquals("The found list of DTO should contain one",1,dtos.size());
		assertEquals("The found DTO is not equal to the one saved",dto,dtos.get(0));
	}

}
