package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigInteger;
import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.CategoryDTOImpl;
import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.impl.factory.CategoryDTOImplFactory;

/**
 * Abstract Test Case for {@link CategoryDAO} implementations.
 * @author stefanborghys
 *
 */
public abstract class AbstractCategoryDAOTest extends AbstractIdDAOTest<BigInteger,CategoryDTOImpl,CategoryDAO> {
	
	@Override
	public CategoryDTOImpl createDTO() {
		return CategoryDTOImplFactory.createNewPolitiek();
	}
	
	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created CategoryDTO name should not be null",getDTO().getName());
		assertNotNull("The created CategoryDTO link should not be null",getDTO().getLink());
	}

	/**
	 * Test finding {@link CategoryDTOImpl} by name before and after saving.
	 */
	@Test
	public void testFindByName(){
		List<CategoryDTOImpl> categoryDTOImpls=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of CategoryDTO should be null when nothing is saved",categoryDTOImpls);
		assertEquals("The list of CategoryDTO should be emtpy when nothing is saved",0,categoryDTOImpls.size());
		setDTO(getDAO().save(getDTO()));
		categoryDTOImpls=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of CetegoryDTO should not be null",categoryDTOImpls);
		assertEquals("The list of CategoryDTO should contain the saved DTO",1,categoryDTOImpls.size());
		assertEquals("The found CategoryDTO should be equal to the one saved",getDTO(),categoryDTOImpls.get(0));
	}
	
	@Test
	public void testFindByNameNull(){
		final List<CategoryDTOImpl> categoryDTOImpls=getDAO().findByName(null);
		assertNotNull("The list of CategoryDTO should be null",categoryDTOImpls);
		assertEquals("The list of CategoryDTO should be emtpy",0,categoryDTOImpls.size());
	}
	
	@Test
	public void testFindByNameEmpty(){
		final List<CategoryDTOImpl> categoryDTOImpls=getDAO().findByName("");
		assertNotNull("The list of CategoryDTO should be null",categoryDTOImpls);
		assertEquals("The list of CategoryDTO should be emtpy",0,categoryDTOImpls.size());
	}
	
	/**
	 * Test finding a {@link CategoryDTOImpl} by link before and after saving it.
	 */
	@Test
	public void testFindByLink(){
		CategoryDTOImpl categoryDTOImpl=getDAO().findByLink(getDTO().getLink());
		assertNull("No CategoryDTO should not be found when nothing is saved",categoryDTOImpl);
		setDTO(getDAO().save(getDTO()));
		categoryDTOImpl=getDAO().findByLink(getDTO().getLink());
		assertNotNull("A CategoryDTO should be found by link when saved",categoryDTOImpl);
		assertEquals("The found CategoryDTO should equal to the one saved",getDTO(),categoryDTOImpl);
	}
	
	@Test
	public void testFindByLinkNull(){
		assertNull("No CategoryDTO should not be found",getDAO().findByLink(null));
	}
	
	@Test
	public void testFindByLinkEmpty(){
		assertNull("No CategoryDTO should not be found",getDAO().findByLink(""));
	}

}
