package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.AuthorDTO;

/**
 * Abstract Test Case for {@link AuthorDAO} implementations.
 * @author stefanborghys
 *
 * @param <DTO> the type of {@link AuthorDTO} used by the {@link AuthorDAO} implementation
 * @param <D> the type of {@link AuthorDAO<DTO>} implementation under test
 */
public abstract class AbstractAuthorDAOTest<DTO extends AuthorDTO,D extends AuthorDAO<DTO>> extends AbstractIdDAOTest<Long,DTO,D> {

	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created AuthorDTO name should not be null",getDTO().getName());
	}
	
	@Test
	public void testFindByName(){
		List<AuthorDTO> authorDTOs=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of AuthorDTO should be null when nothing is saved",authorDTOs);
		assertEquals("The list of AuthorDTO should be emtpy when nothing is saved",0,authorDTOs.size());
		getDAO().save(getDTO());
		authorDTOs=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of AuthorDTO should not be null",authorDTOs);
		assertEquals("The list of AuthorDTO should contain the saved DTO",1,authorDTOs.size());
		assertEquals("The found AuthorDTO should be equal to the one saved",getDTO(),authorDTOs.get(0));
	}

}
