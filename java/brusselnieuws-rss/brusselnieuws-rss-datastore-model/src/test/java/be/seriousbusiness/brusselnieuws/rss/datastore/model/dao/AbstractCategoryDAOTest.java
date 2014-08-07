package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.CategoryDTO;

public abstract class AbstractCategoryDAOTest extends AbstractIdDAOTest<Long,CategoryDTO,CategoryDAO> {
	
	@Override
	@Test
	public void testGetDTO(){
		super.testGetDTO();
		assertNotNull("The created CategoryDTO name should not be null",getDTO().getName());
		assertNotNull("The created CategoryDTO link should not be null",getDTO().getLink());
	}

	/**
	 * Test finding CategoryDTO by name before and after saving.
	 */
	@Test
	public void testFindByName(){
		List<CategoryDTO> categoryDTOs=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of CategoryDTO should be null when nothing is saved",categoryDTOs);
		assertEquals("The list of CategoryDTO should be emtpy when nothing is saved",0,categoryDTOs.size());
		getDAO().save(getDTO());
		categoryDTOs=getDAO().findByName(getDTO().getName());
		assertNotNull("The list of CetegoryDTO should not be null",categoryDTOs);
		assertEquals("The list of CategoryDTO should contain the saved DTO",1,categoryDTOs.size());
		assertEquals("The found CategoryDTO should be equal to the one saved",getDTO(),categoryDTOs.get(0));
	}
	
	/**
	 * Test finding a CategoryDTO by link before and after saving it.
	 */
	@Test
	public void testFindByLink(){
		CategoryDTO categoryDTO=getDAO().findByLink(getDTO().getLink());
		assertNull("No CategoryDTO should not be found when nothing is saved",categoryDTO);
		getDAO().save(getDTO());
		categoryDTO=getDAO().findByLink(getDTO().getLink());
		assertNotNull("A CategoryDTO should be found by link when saved",categoryDTO);
		assertEquals("The found CategoryDTO should equal to the one saved",getDTO(),categoryDTO);
	}

}
