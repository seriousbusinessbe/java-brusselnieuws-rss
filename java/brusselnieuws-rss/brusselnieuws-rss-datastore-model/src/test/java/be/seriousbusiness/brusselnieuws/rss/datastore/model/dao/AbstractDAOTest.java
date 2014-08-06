package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;


/**
 * Defines {@link DAO} base tests.
 * @author stefanborghys
 *
 * @param <DTO> the type of DTO this DAO under test manages
 * @param <D> the type of DAO
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
		dto=createDTO();
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
	 * Test if the created {@link DAO} and {@link DTO} are correct.
	 */
	@Test
	public void assertDAODTO(){
		assertNotNull("The created DAO under test cannot be null",dao);
		assertNotNull("The created DTO under test cannot be null",dto);
	}
	
	/**
	 * Test if saving a <code>null</code> value doesn't throws an Exception
	 */
	@Test
	public void testSaveNull(){
		dao.save(null);
	}
	
	/**
	 * Test saving a newly created DTO.</br>
	 * The List of found {@link DTO} should return the saved DTO.
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
	 * Test the findAll() method before and after saving a DTO.
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
