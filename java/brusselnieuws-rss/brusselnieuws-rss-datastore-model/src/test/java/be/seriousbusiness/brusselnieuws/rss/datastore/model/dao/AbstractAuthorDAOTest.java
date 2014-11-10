package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.AuthorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.AuthorDTOImplFactory;

/**
 * Abstract Test Case for {@link AuthorDAO} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractAuthorDAOTest extends AbstractIdDAOTest<BigInteger,AuthorDTOImpl,AuthorDAO> {
	
	@Override
	public AuthorDTOImpl createDTO() {
		return AuthorDTOImplFactory.createNewBrusselNieuws();
	}

	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created AuthorDTO name should not be null",getDTO().getName());
	}
	
	@Test
	public void testFindByNameNull(){
		List<AuthorDTOImpl> authorDTOImpls=getDAO().findByName(null);
		assertNotNull("The list of AuthorDTO should not be null when nothing is found",authorDTOImpls);
		assertEquals("The list of AuthorDTO should not be empty when nothing is found",0,authorDTOImpls.size());
	}
	
	@Test
	public void testFindByNameEmpty(){
		List<AuthorDTOImpl> authorDTOImpls=getDAO().findByName("");
		assertNotNull("The list of AuthorDTO should not be null when nothing is found",authorDTOImpls);
		assertEquals("The list of AuthorDTO should not be empty when nothing is found",0,authorDTOImpls.size());
	}
	
	@Test
	public void testFindByName(){
		List<AuthorDTOImpl> authorDTOImpls=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of AuthorDTO should not be null when nothing is saved",authorDTOImpls);
		assertEquals("The list of AuthorDTO should be emtpy when nothing is saved",0,authorDTOImpls.size());
		setDTO(getDAO().save(getDTO()));
		authorDTOImpls=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of AuthorDTO should not be null",authorDTOImpls);
		assertEquals("The list of AuthorDTO should contain the saved DTO",1,authorDTOImpls.size());
		assertEquals("The found AuthorDTO should be equal to the one saved",getDTO(),authorDTOImpls.get(0));
	}

}
