package be.seriousbusiness.brusselnieuws.rss.datastore.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import be.seriousbusiness.brusselnieuws.rss.datastore.model.dto.MediumDTO;

public abstract class AbstractMediumDAOTest extends AbstractDAOTest<MediumDTO,MediumDAO> {

	@Override
	@Test
	public void testGetDAO(){
		super.testGetDAO();
		assertNotNull("The created DTO link should not be null",getDTO().getLink());
	}
	
	/**
	 * Test finding a MediumDTO implementation by type before and after saving it.
	 */
	@Test
	public void testFindByLink(){
		MediumDTO mediumDTO=getDAO().findByLink(getDTO().getLink());
		assertNull("No MediumDTO should be found when nothing is saved",mediumDTO);
		getDAO().save(getDTO());
		mediumDTO=getDAO().findByLink(getDTO().getLink());
		assertNotNull("A MediumDTO should be found by type when saved",mediumDTO);
		assertEquals("The found MediumDTO should equal to the one saved",getDTO(),mediumDTO);
	}

}
