package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CreatorDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.CreatorDTOImplFactory;

/**
 * Abstract Test Case for {@link CreatorDAO} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractCreatorDAOTest extends AbstractIdDAOTest<BigInteger,CreatorDTOImpl,CreatorDAO> {
	
	@Override
	public CreatorDTOImpl createDTO() {
		return CreatorDTOImplFactory.createNewTVBrussel();
	}

	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created CreatorDTO name should not be null",getDTO().getName());
	}
	
	@Test
	public void testFindByNameNull(){
		List<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>(getDAO().findByName(null));
		assertNotNull("The list of CreatorDTO should not be null when nothing is found",creatorDTOImpls);
		assertEquals("The list of CreatorDTO should not be empty when nothing is found",0,creatorDTOImpls.size());
	}
	
	@Test
	public void testFindByNameEmpty(){
		List<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>(getDAO().findByName(""));
		assertNotNull("The list of CreatorDTO should not be null when nothing is found",creatorDTOImpls);
		assertEquals("The list of CreatorDTO should not be empty when nothing is found",0,creatorDTOImpls.size());
	}
	
	@Test
	public void testFindByName(){
		List<CreatorDTOImpl> creatorDTOImpls=new ArrayList<CreatorDTOImpl>(getDAO().findByName(getDTO().getName()));
		assertNotNull("The list of CreatorDTO should not be null when nothing is saved",creatorDTOImpls);
		assertEquals("The list of CreatorDTO should be emtpy when nothing is saved",0,creatorDTOImpls.size());
		setDTO(getDAO().save(getDTO()));
		creatorDTOImpls=new ArrayList<CreatorDTOImpl>(getDAO().findByName(getDTO().getName()));
		assertNotNull("The list of CreatorDTO should not be null",creatorDTOImpls);
		assertEquals("The list of CreatorDTO should contain the saved DTO",1,creatorDTOImpls.size());
		assertEquals("The found CreatorDTO should be equal to the one saved",getDTO(),creatorDTOImpls.get(0));
	}

}
